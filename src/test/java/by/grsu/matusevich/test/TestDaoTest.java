package by.grsu.matusevich.test;

import java.util.ArrayList;
import java.util.List;

import by.grsu.matusevich.dataaccess.impl.TestDao;
import by.grsu.matusevich.datamodel.Answer;
import by.grsu.matusevich.datamodel.Question;
import by.grsu.matusevich.datamodel.TesT;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


import junit.framework.Assert;

public class TestDaoTest {

    private static final String TEST_XML_FOLDER = "testXmlFolder";
    private static TestDao testDao;

    @BeforeClass
    public static void createDao() {
        testDao = new TestDao(TEST_XML_FOLDER);
    }


    @AfterClass
    public static void deleteTestXmlData() {
        //	 write code to clean up by.grsu.matusevich.test results from FS

    }

    @Test
    public void testAdd() {
        System.out.println("Start 'save' by.grsu.matusevich.test for TesT");
        final TesT newTest = saveNewTest();
        Assert.assertNotNull(testDao.get(newTest.getId()));
    }

    @Test
    public void testDelete() {
        System.out.println("Start 'delete' by.grsu.matusevich.test for TesT");
        final TesT newTest = saveNewTest();
        testDao.delete(newTest.getId());
        Assert.assertNull(testDao.get(newTest.getId()));
    }

    @Test
    public void testGetAll() {
        System.out.println("Start 'getAll' by.grsu.matusevich.test for TesT");
        final int initialRowsCount = testDao.getAll().size();
        saveNewTest();
        Assert.assertEquals(testDao.getAll().size(), initialRowsCount + 1);
    }

    private TesT saveNewTest() {
        final TesT newTest = new TesT();
        newTest.setTestName("Testing by.grsu.matusevich.test");
        List<Question> questions = new ArrayList<Question>();
        List<Answer> answers = new ArrayList<Answer>();
        Answer answer1 = new Answer();
        answer1.setAnswerText("Sun");
        answer1.setAnswerCorrect(true);
        Answer answer2 = new Answer();
        answer2.setAnswerText("Moon");
        answer2.setAnswerCorrect(false);
        Answer answer3 = new Answer();
        answer3.setAnswerText("Earth");
        answer3.setAnswerCorrect(false);
        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);
        Question question= new Question();
        question.setQuestionText("What is a star?");
        question.setAnswers(answers);
        questions.add(question);
        newTest.setQuestions(questions);
        testDao.saveNew(newTest);
        return newTest;
    }
}