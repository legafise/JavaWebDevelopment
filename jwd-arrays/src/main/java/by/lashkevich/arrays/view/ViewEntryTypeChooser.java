package by.lashkevich.arrays.view;

import by.lashkevich.arrays.arraysutill.reader.ArraysPropertiesReader;
import by.lashkevich.arrays.arraysutill.reader.ArraysViewConsoleReader;
import by.lashkevich.arrays.constant.ArraysConstant;
import by.lashkevich.arrays.controller.ArraysController;
import by.lashkevich.arrays.controller.ArraysRequest;

/**
 * Class for choosing witch type of information entry
 * we will use
 * @author Roman Lashkevich
 */
public final class ViewEntryTypeChooser {
    private static final String SELECT_DATA_ENTRY_TYPE_MESSAGE_KEY = "view.select.creator.message";
    private static final String WRONG_MENU_ITEM_SELECTED_MESSAGE_KEY = "view.wrong.menu.item.selected.message";

    private ViewEntryTypeChooser() {
    }

    public static int chooseEntryType(int viewCommandNumber) {
        ArraysPropertiesReader propertiesReader = ArraysPropertiesReader.getInstance();
        ArraysViewConsoleReader consoleReader = new ArraysViewConsoleReader();
        System.out.println(propertiesReader.readMessageFromBundle(SELECT_DATA_ENTRY_TYPE_MESSAGE_KEY));
        int dataCreatorTypeNumber = consoleReader.readDataEntryNumber();

        if (dataCreatorTypeNumber < 1 || dataCreatorTypeNumber > 2) {
            System.out.println(propertiesReader.readMessageFromBundle(WRONG_MENU_ITEM_SELECTED_MESSAGE_KEY));
            ArraysRequest request = new ArraysRequest();
            request.putParameter(ArraysConstant.COMMAND_NUMBER, viewCommandNumber);
            ArraysController.getInstance().doRequest(request).executeView();
        }

        return dataCreatorTypeNumber;
    }
}
