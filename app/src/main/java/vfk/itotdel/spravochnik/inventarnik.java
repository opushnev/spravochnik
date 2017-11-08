package vfk.itotdel.spravochnik;

/**
 * Created by opushnev_nv on 01.11.2017.
 */

class inventarnik {
   private String name;
   private String invent;
   private String barcode;
   private Integer type;
   private Integer count;
   private String adres;
   private String user;
   private String desc;
public inventarnik(){

}
    public void setAdres(String adres) {
        this.adres = adres;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    void setInvent(String invent) {
        this.invent = invent;
    }

    void setName(String name) {
        this.name = name;
    }

    void setType(Integer type) {
        this.type = type;
    }

    public void setUser(String user) {
        this.user = user;
    }

    Integer getCount() {
        return count;
    }

    Integer getType() {
        return type;
    }

    String getAdres() {
        return adres;
    }

    String getBarcode() {
        return barcode;
    }

    String getDesc() {
        return desc;
    }

    String getInvent() {
        return invent;
    }

    String getName() {
        return name;
    }

    String getUser() {
        return user;
    }

    private inventarnik(String name){
       this.name=name;
    }

}
