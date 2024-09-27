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

import java.util.*;

public class FileCollection {

    PriorityQueue<CustomFile> customFiles = new PriorityQueue<>(10);
    Integer totalSize = 0;

    Map<String, ArrayList<CustomFile>> collectionMap = new HashMap<>();
    Map<String, Integer> collectionMapWithSize = new HashMap<>();



    public static class CustomFile implements Comparable<CustomFile> {
        String fileName;
        int filesize;

        public CustomFile(String fileName, int filesize) {
            this.fileName = fileName;
            this.filesize = filesize;
        }

        @Override
        public int compareTo(CustomFile o) {
            return Integer.compare(o.filesize, this.filesize);
        }

        @Override
        public String toString() {
            return "CustomFile{" +
                    "fileName='" + fileName + '\'' +
                    ", filesize=" + filesize +
                    '}';
        }
    }

    class CollectionsSizeComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer s1, Integer s2) {
            return Integer.compare(s1, s2);
        }
    }

    public List<Map.Entry<String,Integer>> getSortedList( Map<String, Integer> collectionMapWithSize){
        ArrayList<Map.Entry<String, Integer>> mapelementsList = new ArrayList<>(collectionMapWithSize.entrySet());
        Collections.sort(mapelementsList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return mapelementsList.subList(0,2);
    }
    public void readFilesIntoBucket(CustomFile file, String collectionName) {
        totalSize = totalSize + file.filesize;
        customFiles.add(file);
        collectionMap.putIfAbsent(collectionName, new ArrayList<>());
        collectionMap.get(collectionName).add(file);
        if (collectionMapWithSize.get(collectionName) == null) {
            collectionMapWithSize.put(collectionName, file.filesize);
        } else {
            collectionMapWithSize.put(collectionName, collectionMapWithSize.get(collectionName) + file.filesize);
        }


    }

    public static void main(String[] args) {
        FileCollection fc = new FileCollection();
        CustomFile file1 = new CustomFile("abc1xt", 10);
        CustomFile file2 = new CustomFile("abc2txt", 20);
        CustomFile file3 = new CustomFile("abc3txt", 30);
        CustomFile file4 = new CustomFile("abc4txt", 5);


        fc.readFilesIntoBucket(file1, "collectionName1");
        fc.readFilesIntoBucket(file2, "collectionName2");
        fc.readFilesIntoBucket(file4, "collectionName3");
        fc.readFilesIntoBucket(file3, "collectionName1");
        while (!fc.customFiles.isEmpty()) {
            System.out.println(fc.customFiles.poll());
        }

        List<Map.Entry<String,Integer>> finalList = fc.getSortedList(fc.collectionMapWithSize);
        System.out.println("Top 2 "+ finalList);
        System.out.println("Total size "+ fc.totalSize);

    }
}
