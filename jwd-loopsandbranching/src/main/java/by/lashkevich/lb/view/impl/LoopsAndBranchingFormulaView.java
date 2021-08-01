package by.lashkevich.lb.view.impl;

import by.lashkevich.lb.constant.LoopsAndBranchingConstant;
import by.lashkevich.lb.controller.Request;
import by.lashkevich.lb.exception.LoopsAndBranchingReaderException;
import by.lashkevich.lb.reader.LoopsAndBranchingReader;
import by.lashkevich.lb.reader.LoopsAndBranchingReaderFactory;
import by.lashkevich.lb.server.LoopsAndBranchingServer;
import by.lashkevich.lb.view.View;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class LoopsAndBranchingFormulaView implements View {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final String FILE_NOT_FOUND_MESSAGE = "File for reading not found";
    private static final int MAIN_FORWARD_COMMAND_NUMBER = 6;
    private LoopsAndBranchingServer server;
    private LoopsAndBranchingReader dataReader;

    public LoopsAndBranchingFormulaView() {
        server = new LoopsAndBranchingServer();
    }

    @Override
    public void executeView() {
        Request request = new Request();

        try {
            dataReader = LoopsAndBranchingReaderFactory.getInstance().createDataCreator();
            List<String> squareRootFormulaData = dataReader.readSquareRootFormulaData();
            request.putParameter(LoopsAndBranchingConstant.COMMAND_NUMBER, getViewCommandNumber());
            request.putParameter(LoopsAndBranchingConstant.DATA_NAME, squareRootFormulaData);
            server.handleRequest(request);
        } catch (LoopsAndBranchingReaderException e) {
            LOGGER.log(Level.ERROR, e);
            System.out.println(FILE_NOT_FOUND_MESSAGE);
            request.putParameter(LoopsAndBranchingConstant.COMMAND_NUMBER, MAIN_FORWARD_COMMAND_NUMBER);
            server.handleRequest(request);
        }
    }

    @Override
    public int getViewCommandNumber() {
        return 10;
    }
}
