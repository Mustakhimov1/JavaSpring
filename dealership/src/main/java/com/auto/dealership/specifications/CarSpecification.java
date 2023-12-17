package com.auto.dealership.specifications;

import com.auto.dealership.model.Car;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CarSpecification implements Specification<Car> {
    private final String name;
    private final Double priceGe;
    private final Double priceLe;

    public CarSpecification(String name, Double priceGe, Double priceLe) {
        this.name = name;
        this.priceGe = priceGe;
        this.priceLe = priceLe;
    }

    @Override
    public Predicate toPredicate(Root<Car> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (name != null) predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
        if (priceGe != null) predicates.add(criteriaBuilder.ge(root.get("price"), priceGe));
        if (priceLe != null) predicates.add(criteriaBuilder.le(root.get("price"), priceLe));

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
