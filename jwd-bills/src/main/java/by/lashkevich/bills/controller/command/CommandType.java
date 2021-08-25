package by.lashkevich.bills.controller.command;

import by.lashkevich.bills.controller.command.impl.*;

import java.util.Arrays;

public enum CommandType {
    CALCULATE_CLIENT_TOTAL_NEGATIVE_BILLS_AMOUNT(new CalculateClientTotalNegativeBillsAmountCommand(), -5),
    CALCULATE_CLIENT_TOTAL_POSITIVE_BILLS_AMOUNT(new CalculateClientTotalPositiveBillsAmountCommand(), -4),
    CALCULATE_CLIENT_TOTAL_BILLS_AMOUNT(new CalculateClientTotalBillsAmountCommand(), -3),
    FIND_CLIENT_BY_ID(new FindClientByIdCommand(), -2),
    MAIN_FORWARD(new MainForwardCommand(), -1),
    MENU_EXIT(new MenuExitCommand(), 0),
    CHOOSE_LOCALE(new ChooseLocaleCommand(), 1),
    CLIENT_VIEW_FORWARD(new ClientViewForwardCommand(), 2);

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
