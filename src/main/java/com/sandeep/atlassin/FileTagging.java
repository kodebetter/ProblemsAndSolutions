/*
 * *
 *  * Copyright ${YEAR} ${USER}
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.sandeep.atlassin;

import java.io.File;
import java.util.*;

public class FileTagging {


    private Map<String, List<CustomFile>> collectionMap;
    private Map<String, Integer> collectionFilesSize;
    private int totalFileSize;

    public FileTagging(){
        this.collectionMap = new HashMap<>();
        this.collectionFilesSize = new HashMap<>();
        this.totalFileSize = 0;
    }


    public int addFile(String fileName, int size, List<String> collections){
        this.totalFileSize += size;
        CustomFile file = new CustomFile(fileName, size);
        if(collections == null){
            return this.totalFileSize;
        }
        for(String collection : collections) {
            collectionMap.putIfAbsent(collection, new ArrayList<>());
            collectionMap.get(collection).add(file);
            collectionFilesSize.put(collection, collectionFilesSize.getOrDefault(collection, 0) + size);
        }
        return this.totalFileSize;
    }

    public Map.Entry<String, Integer>[]  calculateTopK(int k){
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue() < o2.getValue()){
                    return -1;
                }
                if(o1.getValue() > o2.getValue()){
                    return 1;
                }
                int compareTo = o1.getKey().compareTo(o2.getKey());
                if(compareTo > 0)
                    return -1;
                if(compareTo < 0)
                    return 1;
                return 0;
            }
        });

        for(Map.Entry<String, Integer> entry : collectionFilesSize.entrySet()){
            queue.add(entry);
            if(queue.size() > k)
                queue.remove();
        }
        Map.Entry<String, Integer>[] topK= new Map.Entry[queue.size()];
        for(int i = queue.size()-1; i >= 0; i--){
            topK[i] = queue.remove();
        }

        return topK;
    }

    public static void main(String[] args) {
        /*
        file1.txt(size: 100)
        file2.txt(size: 200) in collection "collection1"
        file3.txt(size: 200) in collection "collection1"
        file4.txt(size: 300) in collection "collection2"
        file5.txt(size: 100)
         */
        FileTagging fc = new FileTagging();
        fc.addFile("file1.txt", 100, null);
        fc.addFile("file2.txt", 200, Arrays.asList(new String[]{"collection1"}));
        fc.addFile("file3.txt", 200, Arrays.asList(new String[]{"collection1"}));
        fc.addFile("file4.txt", 300, Arrays.asList(new String[]{"collection2"}));
        System.out.println(fc.addFile("file5.txt", 100, null));
        System.out.println(fc.calculateTopK(2));
    }

    private class CustomFile{
        String fileName;
        int filesize;

        public CustomFile(String fileName, int filesize) {
            this.fileName = fileName;
            this.filesize = filesize;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public int getFilesize() {
            return filesize;
        }

        public void setFilesize(int filesize) {
            this.filesize = filesize;
        }
    }




}
