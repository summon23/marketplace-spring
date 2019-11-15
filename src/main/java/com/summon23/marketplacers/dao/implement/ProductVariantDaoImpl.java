package com.summon23.marketplacers.dao.implement;

import com.summon23.marketplacers.dao.ProductVariantDao;
import com.summon23.marketplacers.entity.ProductVariant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class ProductVariantDaoImpl  extends JdbcDaoSupport implements ProductVariantDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    @Transactional
    public void updateName(Long catalogId, String newName) {
//        Long productVariantId = productVariant.getId();
        String sql = "UPDATE product_variant SET long_name = ? WHERE id = ? ";
        getJdbcTemplate().update(sql, new Object[]{newName, catalogId });

        if (newName.equals("TEST")) {
            throw new RuntimeException("Rollback");
        }
    }
}
