package io.quarkus.samples.petclinic.dto.perfume;


import java.util.List;

public class PerfumeSearchRequestDto {
    public List<String> getPerfumers() {
        return perfumers;
    }
    public void setPerfumers(List<String> perfumers) {
        this.perfumers = perfumers;
    }
    public List<String> getGenders() {
        return genders;
    }
    public void setGenders(List<String> genders) {
        this.genders = genders;
    }
    public List<Integer> getPrices() {
        return prices;
    }
    public void setPrices(List<Integer> prices) {
        this.prices = prices;
    }
    public String getPerfumer() {
        return perfumer;
    }
    public void setPerfumer(String perfumer) {
        this.perfumer = perfumer;
    }
    public String getPerfumeGender() {
        return perfumeGender;
    }
    public void setPerfumeGender(String perfumeGender) {
        this.perfumeGender = perfumeGender;
    }
    private List<String> perfumers;
    private List<String> genders;
    private List<Integer> prices;
    private String perfumer;
    private String perfumeGender;
}
