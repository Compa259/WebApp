package masjav.nmd.spring.service;

import masjav.nmd.spring.model.ItemCategory;
import masjav.nmd.spring.repository.ItemCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ItemCategoryService {
    @Autowired
    ItemCategoryRepository itemCategoryRepository;

    @Transactional
    public List<ItemCategory> findByCategoryId(Long id){
        return (List<ItemCategory>)  itemCategoryRepository.findByCategoryId(id);
    }
}
