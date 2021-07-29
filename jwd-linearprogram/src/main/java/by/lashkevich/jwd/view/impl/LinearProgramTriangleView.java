package by.lashkevich.jwd.view.impl;

import by.lashkevich.jwd.constant.LinearProgramConstant;
import by.lashkevich.jwd.controller.Request;
import by.lashkevich.jwd.exception.LinearProgramReaderException;
import by.lashkevich.jwd.reader.LinearProgramReader;
import by.lashkevich.jwd.reader.LinearProgramReaderFactory;
import by.lashkevich.jwd.reader.impl.LinearProgramConsoleReader;
import by.lashkevich.jwd.reader.impl.LinearProgramFileReader;
import by.lashkevich.jwd.server.LinearProgramServer;
import by.lashkevich.jwd.view.View;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class LinearProgramTriangleView implements View {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final String FILE_NOT_FOUND_MESSAGE = "File for reading not found";
    private static final int MAIN_FORWARD_COMMAND_NUMBER = 6;
    private LinearProgramServer server;
    private LinearProgramReader dataReader;

    public LinearProgramTriangleView() {
        server = new LinearProgramServer();
    }

    @Override
    public void executeView() {
        Request request = new Request();

        try {
            dataReader = LinearProgramReaderFactory.getInstance().createDataCreator();
            List<String> triangleData = dataReader.readTriangleData();
            request.putParameter(LinearProgramConstant.COMMAND_NUMBER, getViewCommandNumber());
            request.putParameter(LinearProgramConstant.DATA_NAME, triangleData);
            server.handleRequest(request);
        } catch (LinearProgramReaderException e) {
            LOGGER.log(Level.ERROR, e);
            System.out.println(FILE_NOT_FOUND_MESSAGE);
            request.putParameter(LinearProgramConstant.COMMAND_NUMBER, MAIN_FORWARD_COMMAND_NUMBER);
            server.handleRequest(request);
        }
    }

    @Override
    public int getViewCommandNumber() {
        return 7;
    }

    public LinearProgramReader getDataReader() {
        return dataReader;
    }

    public void setDataReader(LinearProgramReader dataReader) {
        this.dataReader = dataReader;
    }
}
