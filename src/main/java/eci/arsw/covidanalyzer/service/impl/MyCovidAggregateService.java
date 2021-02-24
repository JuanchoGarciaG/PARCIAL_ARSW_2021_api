package eci.arsw.covidanalyzer.service.impl;

import eci.arsw.covidanalyzer.model.Result;
import eci.arsw.covidanalyzer.model.ResultType;
import eci.arsw.covidanalyzer.service.ICovidAggregateService;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The type My covid aggregate service.
 */
@Component("MyCovidAggregateService")
public class MyCovidAggregateService implements ICovidAggregateService {

    /**
     * The Result hash.
     */
    HashMap<ResultType,List<Result>> resultHash;

    /**
     * Instantiates a new My covid aggregate service.
     */
    public MyCovidAggregateService() {
        this.resultHash = new HashMap<>();
        List<Result> results = generateResult();
        results.forEach(x->{
            if(resultHash.containsKey(x.getResultType())){
                resultHash.get(x.getResultType()).add(x);
            }else{
                List<Result> aux = new ArrayList<>();
                aux.add(x);
                resultHash.put(x.getResultType(),aux);
            }
        });
        System.out.println("HOLA PUTA"+resultHash);
    }

    private List<Result> generateResult(){
        Result result = new Result(UUID.randomUUID(), "Rodrigo", "Rodriguez", "Helicoptero Apache Militar No binario", "rodri@gmail.com","15-10-1995", "29-06-2021", true, 0.9, ResultType.TRUE_POSITIVE);
        Result result1 = new Result(UUID.randomUUID(), "Juancho", "Garcia", "Otaku", "juanchog@gmail.com","25-10-1999", "29-06-2021", true, 0.92, ResultType.TRUE_POSITIVE);
        Result result2 = new Result(UUID.randomUUID(), "Danilo", "Alberio", "Hombre", "Danilo@gmail.com","25-10-1969", "29-06-2021", false, 0.9, ResultType.FALSE_NEGATIVE);
        Result result3 = new Result(UUID.randomUUID(), "Mario", "Bross", "Plomero", "nintendo@gmail.com","25-10-1989", "30-06-2021", false, 0.9, ResultType.FALSE_POSITIVE);
        List<Result> aux = new ArrayList<>();
        aux.add(result);
        aux.add(result1);
        aux.add(result2);
        aux.add(result3);
        return aux;
    }

    @Override
    public boolean aggregateResult(Result result, ResultType type) {
        if(resultHash.containsKey(type)){
            resultHash.get(type).add(result);
            return true;
        }
        List<Result> aux = new ArrayList<>();
        aux.add(result);
        resultHash.put(type,aux);
        return true;
    }

    @Override
    public List<Result> getResult(ResultType type) {
        return resultHash.get(type);
    }

    @Override
    public List<Result> upsertPersonWithMultipleTests(UUID id, ResultType type) {
        for( Result r: getResult(type)){
            if(r.getId().equals(id)){
                r.setResultType(type);
                r.setNumberTest(r.getNumberTest()+1);
            }
        }
        return getResult(type);
    }

    @Override
    public List<Result> ListByDate(String testDate) {
        List<Result> returnValues = new ArrayList<>();
        List<Result> values = resultHash.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        for(Result r: values){
            if(r.getTestDate().equals(testDate)){
                returnValues.add(r);
            }
        }
        return returnValues;
    }

}
