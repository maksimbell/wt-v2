package com.wt.dao.impl;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.wt.repository.Criteria;
import com.wt.dao.CaseDAO;
import com.wt.dao.DAOException;
import com.wt.dao.wrapper.CaseWrapper;
import com.wt.entity.Case;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CaseDAOImpl implements CaseDAO {

    private static final String PATH = "src\\main\\java\\data\\cases.xml";

    @Override
    public List<Case> find(Criteria criteria) throws DAOException {
        try (var fileInputStream = new FileInputStream(PATH)) {

            var mapper = new XmlMapper();
            var xmlString = new String(fileInputStream.readAllBytes());
            var cases = mapper.readValue(xmlString, CaseWrapper.class).getCases();

            var criteriaMap = criteria.getCriteriaMap();
            var result = new ArrayList<Case>();

            if (criteriaMap.isEmpty()) {
                return cases;
            } else {
                criteriaMap.forEach((key, value) -> result.addAll(
                        cases.stream().filter(p -> {
                            try {
                                var field = p.getClass().getDeclaredField(key);
                                field.setAccessible(true);
                                return field.get(p).equals(value);
                            } catch (NoSuchFieldException | IllegalAccessException e) {
                                throw new RuntimeException(e);
                            }
                        }).toList()
                ));
            }
            return result;
        } catch (IOException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void save(Case userCase) throws DAOException {
        try (var fileOutputStream = new FileOutputStream(PATH)) {
            var mapper = new XmlMapper();
            var url = new File(PATH).toURI().toURL();
            var caseWrapper = mapper.readValue(url, CaseWrapper.class);
            caseWrapper.add(userCase);
            fileOutputStream.write(mapper.writeValueAsBytes(caseWrapper));
        } catch (IOException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public void update(Case userCase) throws DAOException {
        try (var fileInputStream = new FileInputStream(PATH);
             var fileOutputStream = new FileOutputStream(PATH)) {

            var mapper = new XmlMapper();
            var xmlString = new String(fileInputStream.readAllBytes());
            var cases = mapper.readValue(xmlString, CaseWrapper.class).getCases();

            cases.removeIf(d -> d.getCardNum().equals(userCase.getCardNum()));
            cases.add(userCase);

            fileOutputStream.write(mapper.writeValueAsBytes(new CaseWrapper(cases)));
        } catch (IOException e) {
            throw new DAOException(e);
        }
    }
}
