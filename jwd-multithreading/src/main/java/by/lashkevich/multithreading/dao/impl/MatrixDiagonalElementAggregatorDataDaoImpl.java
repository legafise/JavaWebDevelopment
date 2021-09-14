package by.lashkevich.multithreading.dao.impl;

import by.lashkevich.multithreading.dao.DaoException;
import by.lashkevich.multithreading.dao.FileFinder;
import by.lashkevich.multithreading.dao.MatrixDiagonalElementAggregatorDataDao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixDiagonalElementAggregatorDataDaoImpl implements MatrixDiagonalElementAggregatorDataDao {
    private static final String THREADS_INFO_FILE_NAME = "ThreadsInfo.txt";
    private static final String THREAD_ELEMENTS_SEPARATION_SIGN = " ";
    private List<Integer> threadAmountRange;
    private List<Integer> parsedThreadData;

    public MatrixDiagonalElementAggregatorDataDaoImpl() {
        readMatrixDiagonalElementAggregatorData();
    }

    @Override
    public List<Integer> findMatrixDiagonalElementAggregatorsData() {
        return parsedThreadData;
    }

    @Override
    public List<Integer> getThreadAmountRange() {
        return threadAmountRange;
    }

    private void readMatrixDiagonalElementAggregatorData() {
        try {
            FileFinder fileFinder = new FileFinder();
            Stream<String> threadsData = Files.lines(Paths.get(fileFinder
                    .findInfoFile(THREADS_INFO_FILE_NAME).getPath()));
            Iterator<String> threadDataIterator = threadsData.iterator();
            threadAmountRange = Arrays.stream(threadDataIterator.next().split(THREAD_ELEMENTS_SEPARATION_SIGN))
                    .map(Integer::parseInt).collect(Collectors.toList());
            parsedThreadData = mapThreadData(threadDataIterator);
        } catch (IOException e) {
            throw new DaoException(e.getMessage());
        }
    }

    private List<Integer> mapThreadData(Iterator<String> threadDataIterator) {
        List<Integer> threadsData = new ArrayList<>();
        while (threadDataIterator.hasNext()) {
            threadsData.add(Integer.parseInt(threadDataIterator.next()));
        }

        return threadsData;
    }
}
