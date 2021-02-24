package eci.arsw.covidanalyzer.service;

import eci.arsw.covidanalyzer.model.Result;
import eci.arsw.covidanalyzer.model.ResultType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * The interface Covid aggregate service.
 */
@Service
public interface ICovidAggregateService {

    /**
     * Add a new result into the specified result type storage.
     *
     * @param result the result
     * @param type   the type
     * @return boolean
     */
    boolean aggregateResult(Result result, ResultType type);

    /**
     * Get all the results for the specified result type.
     *
     * @param type the type
     * @return result
     */
    List<Result> getResult(ResultType type);

    /**
     * Upsert person with multiple tests list.
     *
     * @param id   the id
     * @param type the type
     * @return list
     */
    List<Result> upsertPersonWithMultipleTests(UUID id, ResultType type);


    List<Result> ListByDate(String date);
}
