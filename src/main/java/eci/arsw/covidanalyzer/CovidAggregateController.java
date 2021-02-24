package eci.arsw.covidanalyzer;

import eci.arsw.covidanalyzer.model.Result;
import eci.arsw.covidanalyzer.model.ResultType;
import eci.arsw.covidanalyzer.service.ICovidAggregateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Covid aggregate controller.
 */
@RestController
public class CovidAggregateController {
    /**
     * The Covid aggregate service.
     */
    @Autowired
    @Qualifier("MyCovidAggregateService")
    ICovidAggregateService covidAggregateService;


    /*POST Methods*/

    /**
     * Add true positive result response entity.
     *
     * @param result the result
     * @return the response entity
     */
    @RequestMapping(value = "/covid/result/true-positive", method = RequestMethod.POST)
    public ResponseEntity addTruePositiveResult(@RequestBody Result result) {
        return new ResponseEntity<>(covidAggregateService.aggregateResult(result, ResultType.TRUE_POSITIVE), HttpStatus.CREATED);
    }

    /**
     * Add true negative result response entity.
     *
     * @param result the result
     * @return the response entity
     */
    @RequestMapping(value = "/covid/result/true-negative", method = RequestMethod.POST)
    public ResponseEntity addTrueNegativeResult(@RequestBody Result result) {
        return new ResponseEntity<>(covidAggregateService.aggregateResult(result, ResultType.TRUE_NEGATIVE), HttpStatus.CREATED);
    }

    /**
     * Add false positive result response entity.
     *
     * @param result the result
     * @return the response entity
     */
    @RequestMapping(value = "/covid/result/false-positive", method = RequestMethod.POST)
    public ResponseEntity addFalsePositiveResult(@RequestBody Result result) {
        return new ResponseEntity<>(covidAggregateService.aggregateResult(result, ResultType.FALSE_POSITIVE), HttpStatus.CREATED);
    }

    /**
     * Add false negative result response entity.
     *
     * @param result the result
     * @return the response entity
     */
    @RequestMapping(value = "/covid/result/false-negative", method = RequestMethod.POST)
    public ResponseEntity addFalseNegativeResult(@RequestBody Result result) {
        return new ResponseEntity<>(covidAggregateService.aggregateResult(result, ResultType.FALSE_NEGATIVE), HttpStatus.CREATED);
    }

    /*GET Methods*/

    /**
     * Gets true positive result.
     *
     * @return the true positive result
     */
    @RequestMapping(value = "/covid/result/true-positive", method = RequestMethod.GET)
    public ResponseEntity getTruePositiveResult() {
        return new ResponseEntity<>(covidAggregateService.getResult(ResultType.TRUE_POSITIVE), HttpStatus.ACCEPTED);
    }

    /**
     * Gets true negative result.
     *
     * @return the true negative result
     */
    @RequestMapping(value = "/covid/result/true-negative", method = RequestMethod.GET)
    public ResponseEntity getTrueNegativeResult() {
        return new ResponseEntity<>(covidAggregateService.getResult(ResultType.TRUE_NEGATIVE), HttpStatus.ACCEPTED);
    }

    /**
     * Gets false positive result.
     *
     * @return the false positive result
     */
    @RequestMapping(value = "/covid/result/false-positive", method = RequestMethod.GET)
    public ResponseEntity getFalsePositiveResult() {
        return new ResponseEntity<>(covidAggregateService.getResult(ResultType.FALSE_POSITIVE), HttpStatus.ACCEPTED);
    }

    /**
     * Gets false negative result.
     *
     * @return the false negative result
     */
    @RequestMapping(value = "/covid/result/false-negative", method = RequestMethod.GET)
    public ResponseEntity getFalseNegativeResult() {
        return new ResponseEntity<>(covidAggregateService.getResult(ResultType.FALSE_NEGATIVE), HttpStatus.ACCEPTED);
    }

    /**
     * Gets false negative result.
     *
     * @return the false negative result
     */
    @RequestMapping(value = "/covid/result/testdate/{date}", method = RequestMethod.GET)
    public ResponseEntity getResultByDate(@PathVariable String date) {
        return new ResponseEntity<>(covidAggregateService.ListByDate(date), HttpStatus.ACCEPTED);
    }

    /**
     * Save persona with multiple tests response entity.
     *
     * @return the response entity
     */
    /*PUT Method*/
    @RequestMapping(value = "/covid/result/persona/{id}", method = RequestMethod.PUT)
    public ResponseEntity savePersonaWithMultipleTests() {
        List<Result> results = new ArrayList<>();
        for(Result r: covidAggregateService.getResult(ResultType.TRUE_POSITIVE)) {
            results.addAll(covidAggregateService.upsertPersonWithMultipleTests(r.getId(), ResultType.TRUE_POSITIVE));
        }
        ;
        return new ResponseEntity<>(results, HttpStatus.ACCEPTED);
    }


    
}