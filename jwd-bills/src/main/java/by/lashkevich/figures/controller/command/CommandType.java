package by.lashkevich.figures.controller.command;

import by.lashkevich.figures.controller.command.impl.*;

import java.util.Arrays;

public enum CommandType {
    REMOVE_CLIENT_BILL(new RemoveClientBillCommand(), -18),
    ASSIGN_BILL_TO_CLIENT(new AssignBillToClientCommand(), -17),
    REMOVE_BILL_BY_ID(new RemoveBillByIdCommand(), -16),
    CREATE_NEW_BILL(new CreateNewBillCommand(), -15),
    CHANGE_BILL_BALANCE(new ChangeBillBalanceCommand(), -14),
    REMOVE_NEW_CLIENT(new RemoveClientByIdCommand(), -13),
    CREATE_NEW_CLIENT(new CreateNewClientCommand(), -12),
    UNBLOCK_BILL_BY_ID(new UnblockBillByIdCommand(), -11),
    BLOCK_BILL_BY_ID(new BlockBillByIdCommand(), -10),
    FIND_BILLS_BY_BALANCE_IN_RANGE(new FindBillsByBalanceInRangeCommand(), -9),
    BILL_ASCENDING_SORT(new BillsBalanceAscendingSortCommand(), -8),
    BILL_BALANCE_DESCENDING_SORT(new BillsBalanceDescendingSortCommand(), -7),
    FIND_BILL_BY_ID(new FindBillByIdCommand(), -6),
    CALCULATE_CLIENT_TOTAL_NEGATIVE_BILLS_AMOUNT(new CalculateClientTotalNegativeBillsAmountCommand(), -5),
    CALCULATE_CLIENT_TOTAL_POSITIVE_BILLS_AMOUNT(new CalculateClientTotalPositiveBillsAmountCommand(), -4),
    CALCULATE_CLIENT_TOTAL_BILLS_AMOUNT(new CalculateClientTotalBillsAmountCommand(), -3),
    FIND_CLIENT_BY_ID(new FindClientByIdCommand(), -2),
    MAIN_FORWARD(new MainForwardCommand(), -1),
    MENU_EXIT(new MenuExitCommand(), 0),
    CHOOSE_LOCALE(new ChooseLocaleCommand(), 1),
    CLIENT_VIEW_FORWARD(new ClientViewForwardCommand(), 2),
    BILL_VIEW_FORWARD(new BillViewForwardCommand(), 3),
    BANK_INFORMATION(new ShowBankInformationCommand(), 4),
    SAVE_DATA(new SaveDataCommand(), 5);

    private static final String INVALID_COMMAND_WAS_CHOSEN_ERROR_MESSAGE = "Invalid command was chosen";
    private final Command command;
    private final int commandNumber;

    CommandType(Command command, int commandNumber) {
        this.command = command;
        this.commandNumber = commandNumber;
    }

    public int getCommandNumber() {
        return commandNumber;
    }

    public Command getCommand() {
        return command;
    }

    public static Command findCommand(int number) throws CommandException {
        return Arrays.stream(CommandType.values())
                .filter(commandType -> number == commandType.getCommandNumber())
                .map(CommandType::getCommand)
                .findAny()
                .orElseThrow(() -> new CommandException(INVALID_COMMAND_WAS_CHOSEN_ERROR_MESSAGE));
    }
}
