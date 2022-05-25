package com.company.service;

import com.company.model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AnalyzeDataService {

    private List<Register> registers = new ArrayList<>();

    public void execute(){}

    public List<Client> getClients() {
        return registers.stream()
                .filter(reg -> reg instanceof Client)
                .map(reg -> (Client) reg)
                .collect(Collectors.toList());
    }

    public List<Salesman> getSalesman() {
        return registers.stream()
                .filter(reg -> reg instanceof Salesman)
                .map(reg -> (Salesman) reg)
                .collect(Collectors.toList());
    }

    public List<Sale> getSales() {
        return registers.stream()
                .filter(reg -> reg instanceof Sale)
                .map(reg -> (Sale) reg)
                .collect(Collectors.toList());
    }

    public Long getMostExpensiveSaleId() {
        BigDecimal mostExpensivePrice = BigDecimal.ZERO;
        Long mostExpensiveSaleId = 0L;
        List<Sale> sales = getSales();
        for (Sale sale : sales) {
            BigDecimal total = total(sale);
            if (mostExpensivePrice.compareTo(total) <= 0) {
                mostExpensiveSaleId = sale.getId();
                mostExpensivePrice = total;
            }
        }
        return mostExpensiveSaleId;
    }

    public String getWorstSalesman(){
        List<Sale> sales = getSales();
        BigDecimal worstSalePrice = total(sales.get(0));
        Sale worstSale = sales.get(0);
        for(Sale sale : sales) {
            if(worstSalePrice.compareTo(total(sale)) < 0){
            } else {
                worstSalePrice = total(sale);
                worstSale = sale;
            }
        }

        return worstSale.getSalesmanName();
    }

    private BigDecimal total(Sale sale) {
        BigDecimal total = BigDecimal.ZERO;
        for (SaleItem item : sale.getItems()) {
            total = total.add(item.getPrice());
        }
        return total;
    }

    public String getReportResult(){
        return String.format("",
                getClients().size(),
                getSalesman().size(),
                getMostExpensiveSaleId(),
                getWorstSalesman()
        );
    }
}
