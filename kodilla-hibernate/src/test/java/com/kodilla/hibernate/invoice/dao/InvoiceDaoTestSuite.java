
package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product product = new Product("Product 1");
        Product product2 = new Product("Product 2 ");
        Item item = new Item(product, BigDecimal.valueOf(120.0), 10, BigDecimal.valueOf(150));
        Item item2 = new Item(product2, BigDecimal.valueOf(10.0), 3, BigDecimal.valueOf(110));
        item.setProduct(product);
        item2.setProduct(product2);
        List<Item> itemList = new ArrayList<>();
        itemList.add(item);
        itemList.add(item2);
        Invoice invoice = new Invoice("1");
        invoice.setItems(itemList);
        //When
        invoiceDao.save(invoice);
        int id = invoice.getId();
        //Then
        Assert.assertNotEquals(0, id);
        //Clean up
        invoiceDao.delete(invoice);




    }
}

