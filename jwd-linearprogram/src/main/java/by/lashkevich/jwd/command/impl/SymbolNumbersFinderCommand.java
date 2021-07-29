package by.lashkevich.jwd.command.impl;

import by.lashkevich.jwd.command.Command;
import by.lashkevich.jwd.constant.LinearProgramConstant;
import by.lashkevich.jwd.controller.Request;
import by.lashkevich.jwd.reporter.FindNumberOfSymbolReporter;
import by.lashkevich.jwd.service.SymbolNumberService;
import by.lashkevich.jwd.service.impl.LinearProgramSymbolNumberService;
import by.lashkevich.jwd.view.View;
import by.lashkevich.jwd.view.impl.LinearProgramMainView;

import java.util.List;
import java.util.Map;

import static by.lashkevich.jwd.linearprogramutil.transformer.LinearProgramTransformer.transformStringsToCharacter;

public class SymbolNumbersFinderCommand implements Command {
    private SymbolNumberService symbolNumberService;

    public SymbolNumbersFinderCommand() {
        this.symbolNumberService = new LinearProgramSymbolNumberService();
    }

    @Override
    public View execute(Request request) {
        char symbol = transformStringsToCharacter((List<String>) request
                .getParameter(LinearProgramConstant.DATA_NAME));
        Map<Character, Integer> symbolsAndNumbers = symbolNumberService.find(symbol);
        FindNumberOfSymbolReporter.reportIntroducedSymbol(symbol);
        FindNumberOfSymbolReporter.reportSymbolNumbers(symbolsAndNumbers);
        return new LinearProgramMainView();
    }
}
