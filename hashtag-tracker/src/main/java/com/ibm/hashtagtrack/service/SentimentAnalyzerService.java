package com.ibm.hashtagtrack.service;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;
import org.springframework.stereotype.Service;

import java.util.Properties;

/**
 * Sentiment analysis service using CoreNLP Stanford
 *
 * @author Warley Vinicius
 */
@Service
public class SentimentAnalyzerService {

    /**
     * Method that will analyze the sentiment through the text, using NLP.
     *
     * @param text tweet text already handled, without most of the special characters.
     * @return the feeling in an entire school, with values from 0 to 4, totaling 5 types of feelings.
     */
    public int analyseSentimentText(String text) {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, parse, sentiment");

        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        Annotation annotation = pipeline.process(text);
        for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
            Tree tree = sentence.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
            return RNNCoreAnnotations.getPredictedClass(tree);
        }
        return 0;
    }


}
