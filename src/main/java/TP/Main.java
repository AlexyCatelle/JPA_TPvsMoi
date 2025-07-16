package TP;

import TP.dao.ProductElectronicDao;
import TP.dao.ProductFoodDao;
import TP.dao.ProductHousingDao;
import TP.entity.ProductElectronic;
import TP.entity.ProductFood;
import TP.entity.ProductHousing;
import TP.service.ProductService;

import java.time.Duration;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Initialisation des services
        ProductService<ProductFood> foodService = new ProductService<>(new ProductFoodDao());
        ProductService<ProductHousing> housingService = new ProductService<>(new ProductHousingDao());
        ProductService<ProductElectronic> electronicService = new ProductService<>(new ProductElectronicDao());

        System.out.println("=== TEST CRUD PRODUCT ===");

        // ---------- FOOD ----------
        ProductFood apple = ProductFood.builder()
                .name("Pomme")
                .price(0.99)
                .expiryDate(LocalDate.of(2025, 12, 31))
                .build();

        apple = foodService.create(apple);
        System.out.println("Produit ajouté (Food) : " + apple);

        // ---------- HOUSING ----------
        ProductHousing table = ProductHousing.builder()
                .name("Table")
                .price(149.99)
                .height(0.75)
                .width(1.20)
                .build();

        table = housingService.create(table);
        System.out.println("Produit ajouté (Housing) : " + table);

        // ---------- ELECTRONIC ----------
        ProductElectronic laptop = ProductElectronic.builder()
                .name("Laptop")
                .price(899.00)
                .batteryDuration(Duration.ofHours(8))
                .build();

        laptop = electronicService.create(laptop);
        System.out.println("Produit ajouté (Electronic) : " + laptop);

        // ---------- UPDATE TEST ----------
        laptop.setPrice(799.00);
        electronicService.update(laptop, laptop.getId());
        System.out.println("Laptop mis à jour : " + electronicService.getById(laptop.getId()));

        // ---------- DELETE TEST ----------
        boolean deleted = foodService.delete(apple.getId());
        System.out.println("Pomme supprimée : " + deleted);

        // ---------- GET ALL ----------
        System.out.println("Produits Housing : " + housingService.getAll());
        System.out.println("Produits Electronics : " + electronicService.getAll());
    }
}
