package by.lashkevich.lb.view.impl;

import by.lashkevich.lb.constant.LoopsAndBranchingConstant;
import by.lashkevich.lb.controller.LoopsAndBranchingController;
import by.lashkevich.lb.controller.Request;
import by.lashkevich.lb.exception.LoopsAndBranchingReaderException;
import by.lashkevich.lb.reader.LoopsAndBranchingReader;
import by.lashkevich.lb.reader.LoopsAndBranchingReaderFactory;
import by.lashkevich.lb.view.View;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class LoopsAndBranchingPointDistanceFromOrigin implements View {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final String FILE_NOT_FOUND_MESSAGE = "File for reading not found";
    private static final int MAIN_FORWARD_COMMAND_NUMBER = -1;
    private LoopsAndBranchingController controller;
    private LoopsAndBranchingReader dataReader;

    public LoopsAndBranchingPointDistanceFromOrigin() {
        controller = new LoopsAndBranchingController();
    }

    @Override
    public void executeView() {
        Request request = new Request();

        try {
            dataReader = LoopsAndBranchingReaderFactory.getInstance().createDataCreator();
            List<String> pointCheckerData = dataReader.readPointDistanceFromOriginData();
            request.putParameter(LoopsAndBranchingConstant.COMMAND_NUMBER, getViewCommandNumber());
            request.putParameter(LoopsAndBranchingConstant.DATA_NAME, pointCheckerData);
            controller.doRequest(request).executeView();
        } catch (LoopsAndBranchingReaderException e) {
            LOGGER.log(Level.ERROR, e);
            System.out.println(FILE_NOT_FOUND_MESSAGE);
            request.putParameter(LoopsAndBranchingConstant.COMMAND_NUMBER, MAIN_FORWARD_COMMAND_NUMBER);
            controller.doRequest(request).executeView();
        }
    }

    @Override
    public int getViewCommandNumber() {
        return -10;
    }
}
