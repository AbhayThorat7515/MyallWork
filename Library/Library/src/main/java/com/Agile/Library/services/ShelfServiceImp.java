package com.Agile.Library.services;


import com.Agile.Library.dto.ShelfDto;
import com.Agile.Library.entities.Shelf;
import com.Agile.Library.repositories.ShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ShelfServiceImp implements ShelfService{

    @Autowired
private ShelfRepository shelfRepository;

    @Override
    public void addShelf(ShelfDto shelfDto) {
        try {
            Shelf shelf = new Shelf();
            shelf.setShelfName(shelfDto.getShelfName());
            shelfRepository.save(shelf);
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }


}
