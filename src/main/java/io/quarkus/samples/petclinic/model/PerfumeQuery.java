
package io.quarkus.samples.petclinic.model;



public class PerfumeQuery {

    
    public String columnName;

    public Object queryData;

    public Integer index;

    public PerfumeQuery(String columnName, Object queryData, Integer index){
        this.index = index;
        this.queryData = queryData;
        this.columnName = columnName;
    }

}
