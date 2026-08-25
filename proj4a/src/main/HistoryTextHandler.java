// This should say "package main" in your own HistoryTextHandler.java,
// since your file will be in the "main" package.
package main;

import browser.NgordnetQuery;
import browser.NgordnetQueryHandler;

import java.util.List;

public class HistoryTextHandler extends NgordnetQueryHandler {

    NGramMap map;

    public HistoryTextHandler(NGramMap map){
        this.map = map;
    }

    @Override
    public String handle(NgordnetQuery q) {
        List<String> words = q.words();
        int startYear = q.startYear();
        int endYear = q.endYear();
        String response = "";
        for(String word : words){
            response += word + ": " + map.weightHistory(word, startYear, endYear).toString() + "\n";
        }
        return response;
    }
}

