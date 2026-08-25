package main;

import edu.princeton.cs.algs4.In;

import java.util.Collection;
import java.util.TreeMap;

import static main.TimeSeries.MAX_YEAR;
import static main.TimeSeries.MIN_YEAR;

/**
 * An object that provides utility methods for making queries on the
 * Google NGrams dataset (or a subset thereof).
 *
 * An NGramMap stores pertinent data from a "words file" and a "counts
 * file". It is not a map in the strict sense, but it does provide additional
 * functionality.
 *
 * @author Josh Hug
 */
public class NGramMap {

    // TODO: Add any necessary static/instance variables.
    private TreeMap<String, TimeSeries> wordHistory;
    private TimeSeries yearHistory;

    /**
     * Constructs an NGramMap from WORDHISTORYFILENAME and YEARHISTORYFILENAME.
     */
    public NGramMap(String wordHistoryFilename, String yearHistoryFilename) {
        // TODO: Fill in this constructor. See the "NGramMap Tips" section of the spec for help.
        In inWordHistory = new In(wordHistoryFilename);
        In inYearHistory = new In(yearHistoryFilename);

        this.wordHistory = new TreeMap<>();

        while(!inWordHistory.isEmpty()){
            String Line = inWordHistory.readLine();
            String splitLine[] = Line.split("\t");
            if(!this.wordHistory.containsKey(splitLine[0])){
                TimeSeries newMap = new TimeSeries();
                newMap.put(Integer.parseInt(splitLine[1]), Double.parseDouble(splitLine[2]));
                this.wordHistory.put(splitLine[0], newMap);
            }
            else{
                this.wordHistory.get(splitLine[0]).put(Integer.parseInt(splitLine[1]), Double.parseDouble(splitLine[2]));
            }
        }

        this.yearHistory = new TimeSeries();

        while(!inYearHistory.isEmpty()){
            String line = inYearHistory.readLine();
            String[] lineSplit = line.split(",");
            this.yearHistory.put(Integer.parseInt(lineSplit[0]), Double.parseDouble(lineSplit[1]));
        }

    }

    /**
     * Provides the history of WORD between STARTYEAR and ENDYEAR, inclusive of both ends. The
     * returned TimeSeries should be a copy, not a link to this NGramMap's TimeSeries. In other
     * words, changes made to the object returned by this function should not also affect the
     * NGramMap. This is also known as a "defensive copy". If the word is not in the data files,
     * returns an empty TimeSeries.
     */
    public TimeSeries countHistory(String word, int startYear, int endYear) {
        // TODO: Fill in this method.
        TimeSeries countHistory = new TimeSeries(wordHistory.get(word), startYear, endYear);
        return countHistory;
    }

    /**
     * Provides the history of WORD. The returned TimeSeries should be a copy, not a link to this
     * NGramMap's TimeSeries. In other words, changes made to the object returned by this function
     * should not also affect the NGramMap. This is also known as a "defensive copy". If the word
     * is not in the data files, returns an empty TimeSeries.
     */
    public TimeSeries countHistory(String word) {
        // TODO: Fill in this method.
        TimeSeries countHistory = new TimeSeries();
        countHistory.putAll(wordHistory.get(word));
        return countHistory;
    }

    /**
     * Returns a defensive copy of the total number of words recorded per year in all volumes.
     */
    public TimeSeries totalCountHistory() {
        // TODO: Fill in this method.
        TimeSeries totalCountHistory = new TimeSeries();
        totalCountHistory.putAll(yearHistory);
        return totalCountHistory;
    }

    /**
     * Provides a TimeSeries containing the relative frequency per year of WORD between STARTYEAR
     * and ENDYEAR, inclusive of both ends. If the word is not in the data files, returns an empty
     * TimeSeries.
     */
    public TimeSeries weightHistory(String word, int startYear, int endYear) {
        // TODO: Fill in this method.
        TimeSeries nominator = new TimeSeries();
        TimeSeries denominator = new TimeSeries();
        nominator = this.countHistory(word, startYear, endYear);
        denominator = this.totalCountHistory();
        return nominator.dividedBy(denominator);
    }

    /**
     * Provides a TimeSeries containing the relative frequency per year of WORD compared to all
     * words recorded in that year. If the word is not in the data files, returns an empty
     * TimeSeries.
     */
    public TimeSeries weightHistory(String word) {
        // TODO: Fill in this method.
        TimeSeries nominator = new TimeSeries();
        TimeSeries denominator = new TimeSeries();
        nominator = this.countHistory(word);
        denominator = this.totalCountHistory();
        return nominator.dividedBy(denominator);
    }

    /**
     * Provides the summed relative frequency per year of all words in WORDS between STARTYEAR and
     * ENDYEAR, inclusive of both ends. If a word does not exist in this time frame, ignore it
     * rather than throwing an exception.
     */
    public TimeSeries summedWeightHistory(Collection<String> words,
                                          int startYear, int endYear) {
        // TODO: Fill in this method.
        TimeSeries summedWeightHistory = new TimeSeries();
        for(String word: words){
            TimeSeries newWord = this.weightHistory(word, startYear, endYear);
            summedWeightHistory = summedWeightHistory.plus(newWord);
        }
        return summedWeightHistory;
    }

    /**
     * Returns the summed relative frequency per year of all words in WORDS. If a word does not
     * exist in this time frame, ignore it rather than throwing an exception.
     */
    public TimeSeries summedWeightHistory(Collection<String> words) {
        // TODO: Fill in this method.
        TimeSeries summedWeightHistory = new TimeSeries();
        for(String word: words){
            TimeSeries newWord = this.weightHistory(word);
            summedWeightHistory = summedWeightHistory.plus(newWord);
        }
        return summedWeightHistory;
    }

    // TODO: Add any private helper methods.
    // TODO: Remove all TODO comments before submitting.
}
