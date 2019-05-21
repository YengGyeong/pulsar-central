package com.vtw.pulsar.user.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.vtw.pulsar.user.entity.User;

public class UserSpecification {
	
	public static Specification<User> searchUser(long id) {
		return new Specification<User>() {
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				return criteriaBuilder.equal(root.get("id"), id);
			}
		};
	}
	
//	public static Specification<User> searchUser(Map<String, Object> filter) {
//		return (root, query, criteriaBuilder) -> {
//			
//			List<Predicate> predicates = new ArrayList();
//			
//			filter.forEach((key, value) -> {
//				String likeValue = "%" + value + "%";
//				
//				switch(key) {
//				case "userId":
//					predicates.add(criteriaBuilder.like(root.get(key).as(String.class), likeValue));
//					break;
//				}
//			});
//			
//			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
//		}
//	}
}
