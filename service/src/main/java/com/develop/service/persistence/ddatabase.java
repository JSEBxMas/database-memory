package com.develop.service.persistence;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ddatabase {

    private final Map<String, Item> memoria = new ConcurrentHashMap<>();

    public Item crear(Item item) {
        String id = UUID.randomUUID().toString();
        item.setId(id);
        memoria.put(id, item);
        return item;
    }

    public List<Item> listar() {
        return new ArrayList<>(memoria.values());
    }

    public Item obtener(String id) {
        return memoria.get(id);
    }

    public Item actualizar(String id, Item nuevo) {
        if (memoria.containsKey(id)) {
            nuevo.setId(id);
            memoria.put(id, nuevo);
            return nuevo;
        }
        return null;
    }

    public boolean eliminar(String id) {
        return memoria.remove(id) != null;
    }

}
