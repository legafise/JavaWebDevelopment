package by.lashkevich.lb.view.impl;

import by.lashkevich.lb.constant.LoopsAndBranchingConstant;
import by.lashkevich.lb.controller.LoopsAndBranchingController;
import by.lashkevich.lb.controller.Request;
import by.lashkevich.lb.reader.LoopsAndBranchingMainViewReader;
import by.lashkevich.lb.reader.LoopsAndBranchingPropertiesReader;
import by.lashkevich.lb.reader.LoopsAndBranchingReaderFactory;
import by.lashkevich.lb.view.View;

/**
 * Class {@code Object} serves as a menu for selecting a task
 * Implements View interface
 *
 * @author Roman Lashkevich
 * @see by.lashkevich.lb.view.View
 * @see by.lashkevich.lb.reader.LoopsAndBranchingMainViewReader
 */
public class LoopsAndBranchingMainView implements View {
    private static final String NEW_LINE_BREAK = "\n";
    private static final String SELECT_LANGUAGE_MESSAGE = "view.select.language.message";
    private static final String SELECT_TASK_MESSAGE_KEY = "view.select.task.message";
    private static final String SELECT_DATA_ENTRY_TYPE_MESSAGE_KEY = "view.select.entry.message";
    private static final String WRONG_MENU_ITEM_SELECTED_MESSAGE_KEY = "view.wrong.menu.item.selected.message";
    private static final String ENTER_ZERO_TO_END_PROGRAM_MESSAGE_KEY = "view.end.program.message";
    private static final String THE_FIRST_TASK_INFORMATION_KEY = "view.first.task.info.message";
    private static final String THE_FIFTH_TASK_INFORMATION_KEY = "view.fifth.task.info.message";
    private static final String THE_THIRD_TASK_INFORMATION_KEY = "view.third.task.info.message";
    private static final String THE_FOURTH_TASK_INFORMATION_KEY = "view.fourth.task.info.message";
    private static final String THE_SECOND_TASK_INFORMATION_KEY = "view.second.task.info.message";
    private static final String THE_SIXTH_TASK_INFORMATION_KEY = "view.sixth.task.info.message";
    private static final String THE_SEVENTH_TASK_INFORMATION_KEY = "view.seventh.task.info.message";
    private static final String THE_EIGHTH_TASK_INFORMATION_KEY = "view.eighth.task.info.message";
    private static final String THE_NINTH_TASK_INFORMATION_KEY = "view.ninth.task.info.message";
    private static final String THE_TENTH_TASK_INFORMATION_KEY = "view.tenth.task.info.message";
    private static final String THE_ELEVENTH_TASK_INFORMATION_KEY = "view.eleventh.task.info.message";
    private static final String THE_TWELFTH_TASK_INFORMATION_KEY = "view.twelve.task.info.message";
    private static final String THE_THIRTEENTH_TASK_INFORMATION_KEY = "view.thirteen.task.info.message";
    private static final String THE_FOURTEENTH_TASK_INFORMATION_KEY = "view.fourteen.task.info.message";
    private static final String THE_FIFTEENTH_TASK_INFORMATION_KEY = "view.fifteenth.task.info.message";
    private final LoopsAndBranchingController controller;
    private final LoopsAndBranchingMainViewReader reader;
    private final LoopsAndBranchingPropertiesReader propertiesReader;
    private final Request request;

    public LoopsAndBranchingMainView() {
        controller = new LoopsAndBranchingController();
        reader = new LoopsAndBranchingMainViewReader();
        propertiesReader = LoopsAndBranchingPropertiesReader.getInstance();
        request = new Request();
    }

    @Override
    public void executeView() {
        if (!chooseLocale() || !chooseEntryType() || !chooseTask()) {
            System.out.println(propertiesReader.readMessageFromBundle(WRONG_MENU_ITEM_SELECTED_MESSAGE_KEY));
            request.putParameter(LoopsAndBranchingConstant.COMMAND_NUMBER, getViewCommandNumber());
        }

        controller.doRequest(request).executeView();
    }

    @Override
    public int getViewCommandNumber() {
        return -1;
    }

    private boolean chooseTask() {
        System.out.println(propertiesReader.readMessageFromBundle(ENTER_ZERO_TO_END_PROGRAM_MESSAGE_KEY)
                + NEW_LINE_BREAK
                + propertiesReader.readMessageFromBundle(SELECT_TASK_MESSAGE_KEY)
                + NEW_LINE_BREAK
                + propertiesReader.readMessageFromBundle(THE_FIRST_TASK_INFORMATION_KEY)
                + NEW_LINE_BREAK
                + propertiesReader.readMessageFromBundle(THE_SECOND_TASK_INFORMATION_KEY)
                + NEW_LINE_BREAK
                + propertiesReader.readMessageFromBundle(THE_THIRD_TASK_INFORMATION_KEY)
                + NEW_LINE_BREAK
                + propertiesReader.readMessageFromBundle(THE_FOURTH_TASK_INFORMATION_KEY)
                + NEW_LINE_BREAK
                + propertiesReader.readMessageFromBundle(THE_FIFTH_TASK_INFORMATION_KEY)
                + NEW_LINE_BREAK
                + propertiesReader.readMessageFromBundle(THE_SIXTH_TASK_INFORMATION_KEY)
                + NEW_LINE_BREAK
                + propertiesReader.readMessageFromBundle(THE_SEVENTH_TASK_INFORMATION_KEY)
                + NEW_LINE_BREAK
                + propertiesReader.readMessageFromBundle(THE_EIGHTH_TASK_INFORMATION_KEY)
                + NEW_LINE_BREAK
                + propertiesReader.readMessageFromBundle(THE_NINTH_TASK_INFORMATION_KEY)
                + NEW_LINE_BREAK
                + propertiesReader.readMessageFromBundle(THE_TENTH_TASK_INFORMATION_KEY)
                + NEW_LINE_BREAK
                + propertiesReader.readMessageFromBundle(THE_ELEVENTH_TASK_INFORMATION_KEY)
                + NEW_LINE_BREAK
                + propertiesReader.readMessageFromBundle(THE_TWELFTH_TASK_INFORMATION_KEY)
                + NEW_LINE_BREAK
                + propertiesReader.readMessageFromBundle(THE_THIRTEENTH_TASK_INFORMATION_KEY)
                + NEW_LINE_BREAK
                + propertiesReader.readMessageFromBundle(THE_FOURTEENTH_TASK_INFORMATION_KEY)
                + NEW_LINE_BREAK
                + propertiesReader.readMessageFromBundle(THE_FIFTEENTH_TASK_INFORMATION_KEY));
        int commandNumber = reader.readCommandNumber();
        boolean isValidCommandNumber = commandNumber > -1 && commandNumber < 16;
        if (isValidCommandNumber) {
            request.putParameter(LoopsAndBranchingConstant.COMMAND_NUMBER, commandNumber);
        }

        return isValidCommandNumber;
    }

    private boolean chooseEntryType() {
        System.out.println(propertiesReader.readMessageFromBundle(SELECT_DATA_ENTRY_TYPE_MESSAGE_KEY));
        int dataEntryTypeNumber = reader.readDataEntryNumber();
        boolean isValidEntryType = dataEntryTypeNumber > 0 && dataEntryTypeNumber < 3;
        if (isValidEntryType) {
            LoopsAndBranchingReaderFactory.getInstance().setDataReaderNumber(dataEntryTypeNumber);
        }

        return isValidEntryType;
    }

    private boolean chooseLocale() {
        System.out.println(propertiesReader.readMessageFromBundle(SELECT_LANGUAGE_MESSAGE));
        int localeNumber = reader.readLocaleNumber();
        boolean isValidLocaleNumber = localeNumber > 0 && localeNumber < 3;
        if (isValidLocaleNumber) {
            LoopsAndBranchingPropertiesReader.getInstance().setLocaleNumber(localeNumber);
        }

        return isValidLocaleNumber;
    }
}


