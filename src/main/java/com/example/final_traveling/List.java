package com.example.final_traveling;

public class List {
        String destination;
        String distance;
        String costair;
    String costcar;
    String costday;
    String hotel;
    String costhotel;
    String custname;
    String custphone;
    String custemail;
    String custtotal;

        List(String a,String b,String c,String d){
        this.custname=a;
        this.custphone=b;
        this.custemail=c;
        this.custtotal=d;
        }
        List(String destination,String distance,String d,String e,String f,String g,String h){
            this.destination=destination;
            this.distance=distance;
            this.costair=d;
            this.costcar=e;
            this.costday=f;
            this.hotel=g;
            this.costhotel=h;

        }

        public String getDestination() {
            return destination;
        }

        public String getDistance() {
            return distance;
        }
        public String getCostair(){
            return costair;
        }

    public String getCostcar() {
        return costcar;
    }

    public String getCostday() {
        return costday;
    }

    public String getHotel() {
        return hotel;
    }

    public String getCosthotel() {
        return costhotel;
    }

    public String getCustname() {
        return custname;
    }

    public String getCustemail() {
        return custemail;
    }

    public String getCustphone() {
        return custphone;
    }

    public String getCusttotal() {
        return custtotal;
    }
}


