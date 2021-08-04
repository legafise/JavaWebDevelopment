package by.lashkevich.lb.service.impl;

import by.lashkevich.lb.access.AccessType;
import by.lashkevich.lb.service.AccessService;

import java.util.List;

public class LoopsAndBranchingAccessService implements AccessService {
    @Override
    public List<String> checkAccess(int password) {
        return AccessType.checkAccess(password);
    }
}
