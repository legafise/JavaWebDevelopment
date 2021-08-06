package by.lashkevich.lb.command.impl;

import by.lashkevich.lb.command.Command;
import by.lashkevich.lb.constant.LoopsAndBranchingConstant;
import by.lashkevich.lb.controller.Request;
import by.lashkevich.lb.loopsandbranchingutil.transformer.LoopsAndBranchingTransformer;
import by.lashkevich.lb.reporter.FindNumberOfSymbolReporter;
import by.lashkevich.lb.service.SymbolNumberService;
import by.lashkevich.lb.service.impl.LoopsAndBranchingSymbolNumberService;
import by.lashkevich.lb.view.View;
import by.lashkevich.lb.view.impl.ViewType;

import java.util.List;
import java.util.Map;

/**
 * @author Roman Lashkevich
 * @see by.lashkevich.lb.command.Command
 */
public class SymbolNumbersFinderCommand implements Command {
    private SymbolNumberService symbolNumberService;

    public SymbolNumbersFinderCommand() {
        this.symbolNumberService = new LoopsAndBranchingSymbolNumberService();
    }

    @Override
    public View execute(Request request) {
        char symbol = LoopsAndBranchingTransformer.transformStringsToCharacter((List<String>) request
                .getParameter(LoopsAndBranchingConstant.DATA_NAME));
        Map<Character, Integer> symbolsAndNumbers = symbolNumberService.find(symbol);
        FindNumberOfSymbolReporter.reportIntroducedSymbol(symbol);
        FindNumberOfSymbolReporter.reportSymbolNumbers(symbolsAndNumbers);
        return ViewType.MAIN_VIEW.getView();
    }
}
