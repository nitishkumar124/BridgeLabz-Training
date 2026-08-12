package com.example.contactsapp.dao;

import com.example.contactsapp.dto.Contact;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ContactDAOImpl implements ContactDAO {

    private final DataSource dataSource;

    public ContactDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Contact> findAll() {

        List<Contact> contacts = new ArrayList<>();

        String sql = """
                SELECT contact_id, name, email, phone
                FROM contacts
                """;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Contact contact = new Contact();

                contact.setContactId(
                        resultSet.getInt("contact_id"));

                contact.setName(
                        resultSet.getString("name"));

                contact.setEmail(
                        resultSet.getString("email"));

                contact.setPhone(
                        resultSet.getString("phone"));

                contacts.add(contact);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error fetching contacts", e);
        }

        return contacts;
    }

    @Override
    public Contact findById(int id) {

        String sql = """
                SELECT contact_id, name, email, phone
                FROM contacts
                WHERE contact_id = ?
                """;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {

                    Contact contact = new Contact();

                    contact.setContactId(
                            resultSet.getInt("contact_id"));

                    contact.setName(
                            resultSet.getString("name"));

                    contact.setEmail(
                            resultSet.getString("email"));

                    contact.setPhone(
                            resultSet.getString("phone"));

                    return contact;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error finding contact", e);
        }

        return null;
    }

    @Override
    public Contact save(Contact contact) {

        String sql = """
                INSERT INTO contacts (name, email, phone)
                VALUES (?, ?, ?)
                """;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(
                             sql,
                             Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, contact.getName());
            statement.setString(2, contact.getEmail());
            statement.setString(3, contact.getPhone());

            statement.executeUpdate();

            try (ResultSet keys = statement.getGeneratedKeys()) {

                if (keys.next()) {
                    contact.setContactId(keys.getInt(1));
                }
            }

            return contact;

        } catch (SQLException e) {
            throw new RuntimeException("Error saving contact", e);
        }
    }
}