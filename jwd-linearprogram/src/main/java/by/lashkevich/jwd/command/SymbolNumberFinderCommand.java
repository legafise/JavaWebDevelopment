package by.lashkevich.jwd.command;

import by.lashkevich.jwd.creator.DataCreatorFactory;
import by.lashkevich.jwd.exception.LinearProgramCommandException;
import by.lashkevich.jwd.exception.LinearProgramDataCreatorException;
import by.lashkevich.jwd.reporter.FindNumberOfSymbolReporter;
import by.lashkevich.jwd.service.SymbolNumberService;
import by.lashkevich.jwd.service.impl.LinearProgramSymbolNumberService;

import java.util.Map;

public class SymbolNumberFinderCommand implements Command {
    private SymbolNumberService symbolNumberService;

    public SymbolNumberFinderCommand() {
        this.symbolNumberService = new LinearProgramSymbolNumberService();
    }

    @Override
    public void execute() throws LinearProgramCommandException {
        try {
            char symbol = DataCreatorFactory.getInstance().createDataCreator().createSymbol();
            Map<Character, Integer> symbolsAndNumbers = symbolNumberService.find(symbol);
            FindNumberOfSymbolReporter.reportIntroducedSymbol(symbol);
            FindNumberOfSymbolReporter.reportSymbolNumbers(symbolsAndNumbers);
        } catch (LinearProgramDataCreatorException e) {
            throw new LinearProgramCommandException(e);
        }
    }
}
