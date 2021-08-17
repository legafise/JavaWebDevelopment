package by.lashkevich.arrays.view.impl;

import by.lashkevich.arrays.arraysutill.reader.ArraysPropertiesReader;
import by.lashkevich.arrays.arraysutill.reader.ArraysViewConsoleReader;
import by.lashkevich.arrays.constant.ArraysConstant;
import by.lashkevich.arrays.controller.ArraysController;
import by.lashkevich.arrays.controller.ArraysRequest;
import by.lashkevich.arrays.arraysutill.creator.ArraysDataCreatorFactory;
import by.lashkevich.arrays.view.View;

public class ArraysMainView implements View {
    private static final String NEW_LINE_BREAK = "\n";
    private static final String SELECT_LANGUAGE_MESSAGE = "view.select.language.message";
    private static final String SELECT_TASK_MESSAGE_KEY = "view.select.task.message";
    private static final String SELECT_DATA_ENTRY_TYPE_MESSAGE_KEY = "view.select.creator.message";
    private static final String WRONG_MENU_ITEM_SELECTED_MESSAGE_KEY = "view.wrong.menu.item.selected.message";
    private static final String ENTER_ZERO_TO_END_PROGRAM_MESSAGE_KEY = "view.end.program.message";
    private static final String THE_FIRST_TASK_INFORMATION_KEY = "view.first.task.info.message";
    private static final String THE_SECOND_TASK_INFORMATION_KEY = "view.second.task.info.message";
    private final ArraysViewConsoleReader reader;
    private final ArraysPropertiesReader propertiesReader;
    private final ArraysRequest request;


    public ArraysMainView() {
        reader = new ArraysViewConsoleReader();
        propertiesReader = ArraysPropertiesReader.getInstance();
        request = new ArraysRequest();
    }

    @Override
    public void executeView() {
        int mainViewCommandNumber = -1;

        if (!chooseLocale() || !chooseDataCreatorType() || !chooseTask()) {
            System.out.println(propertiesReader.readMessageFromBundle(WRONG_MENU_ITEM_SELECTED_MESSAGE_KEY));
            request.putParameter(ArraysConstant.COMMAND_NUMBER, mainViewCommandNumber);
        }

        ArraysController.getInstance().doRequest(request).executeView();
    }

    private boolean chooseTask() {
        System.out.println(propertiesReader.readMessageFromBundle(ENTER_ZERO_TO_END_PROGRAM_MESSAGE_KEY)
                + NEW_LINE_BREAK
                + propertiesReader.readMessageFromBundle(SELECT_TASK_MESSAGE_KEY)
                + NEW_LINE_BREAK
                + propertiesReader.readMessageFromBundle(THE_FIRST_TASK_INFORMATION_KEY)
                + NEW_LINE_BREAK
                + propertiesReader.readMessageFromBundle(THE_SECOND_TASK_INFORMATION_KEY));
        int commandNumber = reader.readCommandNumber();
        boolean isValidCommandNumber = commandNumber > -1 && commandNumber < 3;
        if (isValidCommandNumber) {
            request.putParameter(ArraysConstant.COMMAND_NUMBER, commandNumber);
        }

        return isValidCommandNumber;
    }

    private boolean chooseDataCreatorType() {
        System.out.println(propertiesReader.readMessageFromBundle(SELECT_DATA_ENTRY_TYPE_MESSAGE_KEY));
        int dataCreatorTypeNumber = reader.readDataEntryNumber();
        boolean isValidEntryType = dataCreatorTypeNumber > 0 && dataCreatorTypeNumber < 3;
        if (isValidEntryType) {
            ArraysDataCreatorFactory.getInstance().setDataCreatorNumber(dataCreatorTypeNumber);
        }

        return isValidEntryType;
    }

    private boolean chooseLocale() {
        System.out.println(propertiesReader.readMessageFromBundle(SELECT_LANGUAGE_MESSAGE));
        int localeNumber = reader.readLocaleNumber();
        boolean isValidLocaleNumber = localeNumber > 0 && localeNumber < 3;
        if (isValidLocaleNumber) {
            ArraysPropertiesReader.getInstance().setLocaleNumber(localeNumber);
        }

        return isValidLocaleNumber;
    }
}
