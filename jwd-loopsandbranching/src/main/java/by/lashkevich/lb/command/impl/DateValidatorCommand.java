package by.lashkevich.lb.command.impl;

import by.lashkevich.lb.command.Command;
import by.lashkevich.lb.constant.LoopsAndBranchingConstant;
import by.lashkevich.lb.controller.Request;
import by.lashkevich.lb.entity.LoopsAndBranchingDate;
import by.lashkevich.lb.exception.LoopsAndBranchingCommandException;
import by.lashkevich.lb.exception.LoopsAndBranchingServiceException;
import by.lashkevich.lb.exception.LoopsAndBranchingTransformerException;
import by.lashkevich.lb.loopsandbranchingutil.transformer.LoopsAndBranchingTransformer;
import by.lashkevich.lb.reporter.DateValidatorReporter;
import by.lashkevich.lb.service.DateService;
import by.lashkevich.lb.service.impl.LoopsAndBranchingDateService;
import by.lashkevich.lb.view.View;
import by.lashkevich.lb.view.impl.ViewType;

import java.util.List;

public class DateValidatorCommand implements Command {
    private DateService dateService;

    public DateValidatorCommand() {
        this.dateService = new LoopsAndBranchingDateService();
    }

    @Override
    public View execute(Request request) throws LoopsAndBranchingCommandException {
        try {
            List<Integer> dateData = LoopsAndBranchingTransformer.transformStringsToIntegers((List<String>) request
                    .getParameter(LoopsAndBranchingConstant.DATA_NAME));
            LoopsAndBranchingDate date = createDate(dateData);
            boolean isValidDate = dateService.validateDate(date);
            DateValidatorReporter.reportDateInfo(date);
            DateValidatorReporter.reportDateValidatingResult(isValidDate);
            return ViewType.MAIN_VIEW.getView();
        } catch (LoopsAndBranchingTransformerException e) {
            throw new LoopsAndBranchingCommandException(e);
        }
    }

    private LoopsAndBranchingDate createDate(List<Integer> dateData) {
        return new LoopsAndBranchingDate(dateData.get(0), dateData.get(1));
    }
}
