package by.lashkevich.jwd.command;

import by.lashkevich.jwd.creator.DataCreatorFactory;
import by.lashkevich.jwd.exception.LinearProgramCommandException;
import by.lashkevich.jwd.exception.LinearProgramDataCreatorException;
import by.lashkevich.jwd.reporter.FindNumberOfSymbolReporter;
import by.lashkevich.jwd.service.LinearProgramSymbolNumberService;

import java.util.Map;

public class SymbolNumberFinderCommand implements Command {
    private LinearProgramSymbolNumberService linearProgramSymbolNumberService;

    public SymbolNumberFinderCommand() {
        this.linearProgramSymbolNumberService = new LinearProgramSymbolNumberService();
    }

    @Override
    public void execute() throws LinearProgramCommandException {
        try {
            char symbol = DataCreatorFactory.getInstance().createDataCreator().createSymbol();
            Map<Character, Integer> symbolsAndNumbers = linearProgramSymbolNumberService.find(symbol);
            FindNumberOfSymbolReporter.reportIntroducedSymbol(symbol);
            FindNumberOfSymbolReporter.reportSymbolNumbers(symbolsAndNumbers);
        } catch (LinearProgramDataCreatorException e) {
            throw new LinearProgramCommandException(e);
        }
    }
}
