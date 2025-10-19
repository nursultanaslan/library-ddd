package com.turkcell.library_cqrs.domain.category.model;


public class Category {

    private final CategoryId id;

    private String name;

    private Category(CategoryId id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Category create(String name){
        validateName(name);
        return new Category(
                CategoryId.generate(),
                name
        );

    }

    public static Category rehydrate(CategoryId id, String name){
        return new Category(
                id,
                name
        );
    }

    public void rename(String name) {
        validateName(name);
        this.name = name;
    }

    private static void validateName(String name){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null");
        }

        if(name.length() > 20){
            throw new IllegalArgumentException("Category name length must be less than 20 characters");
        }
    }

    public CategoryId id() {
        return id;
    }

    public String name() {
        return name;
    }
}
