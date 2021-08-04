package by.lashkevich.lb.command.impl;

import by.lashkevich.lb.command.Command;
import by.lashkevich.lb.constant.LoopsAndBranchingConstant;
import by.lashkevich.lb.controller.Request;
import by.lashkevich.lb.exception.LoopsAndBranchingCommandException;
import by.lashkevich.lb.exception.LoopsAndBranchingTransformerException;
import by.lashkevich.lb.loopsandbranchingutil.transformer.LoopsAndBranchingTransformer;
import by.lashkevich.lb.reporter.AccessCheckerReporter;
import by.lashkevich.lb.service.AccessService;
import by.lashkevich.lb.service.impl.LoopsAndBranchingAccessService;
import by.lashkevich.lb.view.View;
import by.lashkevich.lb.view.impl.ViewType;

import java.util.List;

public class AccessCheckerCommand implements Command {
    private AccessService accessService;

    public AccessCheckerCommand() {
        accessService = new LoopsAndBranchingAccessService();
    }

    @Override
    public View execute(Request request) throws LoopsAndBranchingCommandException {
        try {
            int password = LoopsAndBranchingTransformer
                    .transformStringsToIntegers((List<String>) request
                            .getParameter(LoopsAndBranchingConstant.DATA_NAME)).get(0);
            List<String> result = accessService.checkAccess(password);
            AccessCheckerReporter.reportPasswordInfo(password);
            AccessCheckerReporter.reportAccessCheckResult(result);
            return ViewType.MAIN_VIEW.getView();
        } catch (LoopsAndBranchingTransformerException e) {
            throw new LoopsAndBranchingCommandException(e);
        }
    }
}
