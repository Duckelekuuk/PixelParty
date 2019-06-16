package com.pixelparty.utils;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ItemStackBuilder {

    private final ItemStack itemStack;
    private final ItemMeta itemMeta;

    public static ItemStackBuilder of(Material material) {
        return new ItemStackBuilder(new ItemStack(material));
    }

    public static ItemStackBuilder copyOf(ItemStack itemStack) {
        return new ItemStackBuilder(itemStack.clone());
    }

    private ItemStackBuilder(ItemStack itemStack) {
        this.itemStack = itemStack;
        this.itemMeta = itemStack.getItemMeta();
    }


    public ItemStackBuilder displayName(String displayName) {
        itemMeta.setDisplayName(displayName);
        return this;
    }

    public ItemStackBuilder amount(int amount) {
        itemStack.setAmount(amount);
        return this;
    }

    public ItemStackBuilder damage(int damage) {
        if (itemStack instanceof Damageable) {
            Damageable damageable = (Damageable) itemStack;
            damageable.setDamage(damage);
        } else {
            throw new RuntimeException("Item is not instance of damageable");
        }

        return this;
    }

    public ItemStackBuilder lore(String... lore) {
        itemMeta.setLore(Arrays.asList(lore));
        return this;
    }

    public ItemStackBuilder lore(List<String> lore) {
        itemMeta.setLore(lore);
        return this;
    }

    public ItemStackBuilder unBreakable(boolean unBreakable) {
        itemMeta.setUnbreakable(unBreakable);
        return this;
    }

    public ItemStackBuilder unBreakable() {
        itemMeta.setUnbreakable(true);
        return this;
    }

    public ItemStackBuilder enchant(Enchantment enchantment, int level) {
        itemMeta.addEnchant(enchantment, level, false);
        return this;
    }

    public ItemStackBuilder unsafeEnchant(Enchantment enchantment, int level) {
        itemMeta.addEnchant(enchantment, level, true);
        return this;
    }

    public ItemStackBuilder flags(ItemFlag... itemFlags) {
        itemMeta.addItemFlags(itemFlags);
        return this;
    }

    public ItemStackBuilder flags(List<ItemFlag> itemFlags) {
        itemMeta.addItemFlags(itemFlags.toArray(new ItemFlag[0]));
        return this;
    }

    public ItemStackBuilder attributes(Attribute attribute, AttributeModifier attributeModifier) {
        itemMeta.addAttributeModifier(attribute, attributeModifier);
        return this;
    }

    public ItemStackBuilder attributes(Map<Attribute, AttributeModifier> modifiers) {
        modifiers.forEach((itemMeta::addAttributeModifier));
        return this;
    }

    public ItemStackBuilder attributes(Multimap<Attribute, AttributeModifier> modifiers) {
        if (itemMeta.getAttributeModifiers() == null) {
            itemMeta.setAttributeModifiers(HashMultimap.create());
        }

        itemMeta.getAttributeModifiers().putAll(modifiers);
        return this;
    }

    public ItemStackBuilder changeMeta(Consumer<ItemMeta> metaConsumer) {
        metaConsumer.accept(itemMeta);
        return this;
    }

    public <T extends ItemMeta> ItemStackBuilder changeSpecificMeta(Consumer<T> metaConsumer) {
        T specifiedItemMeta = (T) itemMeta;
        metaConsumer.accept(specifiedItemMeta);
        return this;
    }

    public ItemStack get() {
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
