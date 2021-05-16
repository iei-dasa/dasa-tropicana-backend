
package io.quarkus.samples.petclinic.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.quarkus.panache.common.Sort;
import io.quarkus.samples.petclinic.dto.perfume.PerfumeSearchRequestDto;

import java.util.Set;

@Entity
@Table(name = "perfumes")
public class Perfume extends BaseEntity {

    @Column(name = "description")
    @NotNull
    protected String description;

    @Column(name = "type")
    @NotNull
    protected String type;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPerfumeTitle() {
        return perfumeTitle;
    }

    public void setPerfumeTitle(String perfumeTitle) {
        this.perfumeTitle = perfumeTitle;
    }

    public String getPerfumer() {
        return perfumer;
    }

    public void setPerfumer(String perfumer) {
        this.perfumer = perfumer;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPerfumeGender() {
        return perfumeGender;
    }

    public void setPerfumeGender(String perfumeGender) {
        this.perfumeGender = perfumeGender;
    }

    public String getFragranceTopNotes() {
        return fragranceTopNotes;
    }

    public void setFragranceTopNotes(String fragranceTopNotes) {
        this.fragranceTopNotes = fragranceTopNotes;
    }

    public String getFragranceMiddleNotes() {
        return fragranceMiddleNotes;
    }

    public void setFragranceMiddleNotes(String fragranceMiddleNotes) {
        this.fragranceMiddleNotes = fragranceMiddleNotes;
    }

    public String getFragranceBaseNotes() {
        return fragranceBaseNotes;
    }

    public void setFragranceBaseNotes(String fragranceBaseNotes) {
        this.fragranceBaseNotes = fragranceBaseNotes;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Column(name = "perfume_title")
    @NotNull
    private String perfumeTitle;
    @Column(name = "perfumer")
    @NotNull
    private String perfumer;
    @Column(name = "year")
    private Integer year;
    @Column(name = "country")
    private String country;
    @Column(name = "perfume_gender")
    private String perfumeGender;
    @Column(name = "fragrance_top_notes")
    private String fragranceTopNotes;
    @Column(name = "fragrance_middle_notes")
    private String fragranceMiddleNotes;
    @Column(name = "fragrance_base_notes")
    private String fragranceBaseNotes;
    @Column(name = "filename")
    private String filename;
    @Column(name = "volume")
    private String volume;
    @Column(name = "price")
    private Integer price;

    public static List<Perfume> findByPerfumeTitle(String perfumeTitle) {
        return find("lower(perfumeTitle) like lower(concat(?1, '%')) ", Sort.ascending("perfumeTitle"), perfumeTitle)
                .list();
    }

    public static Collection<Perfume> findByRequest(PerfumeSearchRequestDto perfumeSearchRequestDto) {

        String query = "";
        List<PerfumeQuery> params = new ArrayList<PerfumeQuery>();
        List<PerfumeQuery> params1 = new ArrayList<PerfumeQuery>();


        if (perfumeSearchRequestDto.getGenders() != null) {
            for (String param : perfumeSearchRequestDto.getGenders()) {
                params1.add( new PerfumeQuery("perfume_gender",param, params.size()));
            }
            if(params1.size() > 0 ){
                query = getQueryString(query, params1, params.size());
                params.addAll(params1);
            }
        }
        params1 = new ArrayList<PerfumeQuery>();
        if (perfumeSearchRequestDto.getPrices() != null) {
            for (Integer param : perfumeSearchRequestDto.getPrices()) {
                params1.add( new PerfumeQuery("price",param, params.size()));
            }
            if(params1.size() > 0 ){
                query = getQueryInt(query, params1, params.size());
                params.addAll(params1);
            }
        }
        params1 = new ArrayList<PerfumeQuery>();
        if (perfumeSearchRequestDto.getPerfumers() != null) {
            for (String param : perfumeSearchRequestDto.getPerfumers()) {
                params1.add( new PerfumeQuery("perfumer",param, params.size()));
            }
            if(params1.size() > 0 ){
                query = getQueryString(query, params1, params.size());
                params.addAll(params1);
            }
        }
        
        List<Object> queryParrams = new ArrayList<Object>();
        for (PerfumeQuery string : params) {
            queryParrams.add(string.queryData);
        }
        return find(query, Sort.ascending("perfumeTitle"), queryParrams.toArray()).list();

    }

    public static String getQueryString(String query, List<PerfumeQuery> params, int index){
        String tmpQuery = "";
        for (int i = 0; i < params.size(); i++) {
            if (i == 0) {
                tmpQuery = "lower(" +
                 params.get(i).columnName + ") like lower(concat(?" + (i + 1 + index)  + ", '%')) ";
            } else {
                tmpQuery += " OR lower(" +
                params.get(i).columnName + ")like lower(concat(?" + (i + 1 + index) + ", '%')) ";
            }
        }
        String andStr = "";
        if (query.length() > 0) {
            andStr = " AND ";
        }
        query += andStr +  " ( " + tmpQuery + " ) " ;
        return query;
    }


    public static String getQueryInt(String query, List<PerfumeQuery> params, int index){
        String tmpQuery = "";
        for (int i = 0; i < params.size(); i++) {
            if (i == 0) {
                tmpQuery = params.get(i).columnName + ">= ?" + (i + 1 + index) ;
            } else {
                tmpQuery += " AND " + params.get(i).columnName + "< ?" + (i + 1 + index) ;
            }
        }
        String andStr = "";
        if (query.length() > 0) {
            andStr = " AND ";
        }
        System.out.println("11112222333");

        System.out.println(tmpQuery);
        query += andStr +  " ( " + tmpQuery + " ) " ;
        return query;
    }

}
