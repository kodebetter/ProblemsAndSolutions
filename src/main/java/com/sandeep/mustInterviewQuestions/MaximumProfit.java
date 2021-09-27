package com.sandeep.mustInterviewQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumProfit {

    class Stock implements Comparable<Stock> {
        public int purchasePrice;
        public int sellingPrice;
        public int profit;

        public Stock(int purchasePrice, int s) {
            this.purchasePrice = purchasePrice;
            this.sellingPrice = s;
            this.profit = this.sellingPrice - this.purchasePrice;
        }

        public String toString() {
            return "" + this.profit;
        }

        public int compareTo(Stock b) {
            if (this.profit < b.profit) {
                return 1;
            } else if (this.profit > b.profit) {
                return -1;
            }
            return 0;
        }
    }

    int initialSavings = 0;
    List<Integer> stocksPurchasePrice = null;
    List<Integer> stocksSellingPrice = null;

    public MaximumProfit(int initialInvestment, List<Integer> stocksPurchasePrice, List<Integer> stocksSellingPrice) {
        this.initialSavings = initialInvestment;
        this.stocksPurchasePrice = stocksPurchasePrice;
        this.stocksSellingPrice = stocksSellingPrice;
    }

    public int getMaximumProfit() {
        List<Stock> stocklist = new ArrayList<Stock>();
        int profit = 0;
        for (int i = 0; i < stocksPurchasePrice.size(); i++) {
            stocklist.add(new Stock(stocksSellingPrice.get(i), stocksSellingPrice.get(i)));

        }
        Collections.sort(stocklist);
        int i = 0;
        while (initialSavings > 0 && i < stocklist.size()) {
            int p = stocklist.get(i).purchasePrice;
            int savingsafter = initialSavings - p;
            if (stocklist.get(i).profit < 0 || savingsafter < 0) {
                i++;
                continue;
            }
            initialSavings = savingsafter;
            profit = profit + stocklist.get(i).profit;
            i++;
        }
        return profit;
    }

}
