package de.honorshelter.vanilla.customrecipes;

import com.google.common.collect.Multimap;
import de.honorshelter.vanilla.Function;
import de.honorshelter.vanilla.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CustomRecipes implements Function {

    /* RECIPES:
        8 OAK logs = 4 Chests
        2 OAK logs = 16 sticks
        1 Quartzblock = 4 Quartz
        1 Glowstoneblock = 4 Glowstone
        2 Slabs = 1 Block

        (Furnace)
        1 Rotten Flesh = 1 Leder
     */

    /*
    private ShapedRecipe NAME() {
        ItemStack NAME = new ItemStack(Material.);
        NAME.setAmount(AMOUNT);

        ShapedRecipe recipe = new ShapedRecipe(NAME);
        recipe.shape("   ", "   ", "   ");
        recipe.setIngredient();

        return recipe;
    }
     */


    public void onEnable(Main main) {
        Server server = main.getServer();

        server.addRecipe(chest());
        for (int i = 0; i < 4; i++) {
            server.addRecipe(stick(i));
        }
        server.addRecipe(quartz());
        server.addRecipe(glowstone());

        Map<String, Material[]> material_map = material_list();
        for (Map.Entry<String, Material[]> entry : material_map.entrySet()) {
            for (int i = 0; i < 4; i++) {
                server.addRecipe(slaps(i, entry.getValue()[1], entry.getValue()[0]));
            }
        }

        server.addRecipe(hopper());
        server.addRecipe(leather());
        server.addRecipe(camera());
        server.addRecipe(stick());
        server.addRecipe(ultimateStick());
    }

    //8 OAK logs = 4 OAK chests
    private ShapedRecipe chest() {
        ItemStack chest = new ItemStack(Material.CHEST);
        chest.setAmount(4);

        ShapedRecipe recipe = new ShapedRecipe(chest);
        recipe.shape("www", "w w", "www");
        recipe.setIngredient('w', Material.OAK_LOG);

        return recipe;
    }

    private ShapedRecipe camera() {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
        head = Bukkit.getUnsafe().modifyItemStack(head, "{display:{Name:\"{\\\"Juckt?\\\":\\\"Junge kein Plan\\\"}\"},SkullOwner:{Id:[" + "I;-403550234,-1227534356,-1806171093,-608854317" + "],Properties:{textures:[{Value:\"" + "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2MzNmVjNTMyM2Y3NjVmZjU5ZjkxNmQyZDFhMWVjNzQ5Njg1NGNmN2JkMjZkZDJmMmNiYWRjM2RkNDkyNzljOCJ9fX0=" + "\"}]}}}");
        ItemMeta meta = head.getItemMeta();
        meta.setDisplayName("Kamera");
        head.setItemMeta(meta);
        head.setAmount(1);

        ShapedRecipe recipe = new ShapedRecipe(head);
        recipe.shape("ccr", "iei", "ccc");

        recipe.setIngredient('c', Material.BLACK_CONCRETE);
        recipe.setIngredient('r', Material.REDSTONE);
        recipe.setIngredient('i', Material.IRON_BLOCK);
        recipe.setIngredient('e', Material.ENDER_EYE);

        return recipe;
    }

    //2 OAK logs = 16 sticks
    private ShapedRecipe stick(int ka) {
        ItemStack stick = new ItemStack(Material.STICK);
        stick.setAmount(16);

        ShapedRecipe recipe = new ShapedRecipe(stick);
        switch (ka) {
            case 0:
                recipe.shape("w  ", "w  ", "   ");
                break;
            case 1:
                recipe.shape(" w ", " w ", "   ");
                break;
            case 2:
                recipe.shape("   ", "w  ", "w  ");
                break;
            case 3:
                recipe.shape("   ", " w ", " w ");
                break;
        }
        recipe.setIngredient('w', Material.OAK_LOG);

        return recipe;
    }

    //1 Quartzblock = 4 Quartz
    private ShapelessRecipe quartz() {
        ItemStack quartz = new ItemStack(Material.QUARTZ);
        quartz.setAmount(4);

        ShapelessRecipe recipe = new ShapelessRecipe(quartz);
        recipe.addIngredient(1, Material.QUARTZ_BLOCK);

        return recipe;
    }

    private ShapelessRecipe stick() {
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta meta = stick.getItemMeta();
        meta.setDisplayName("Ehrenstick");
        stick.setItemMeta(meta);
        stick.setAmount(1);

        ShapelessRecipe recipe = new ShapelessRecipe(stick);
        recipe.addIngredient(2, Material.EMERALD);

        return recipe;
    }

    private ShapelessRecipe ultimateStick() {
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta meta = stick.getItemMeta();
        meta.setDisplayName("Ultimativer Stick");
        stick.setItemMeta(meta);
        stick.setAmount(1);


        ShapelessRecipe recipe = new ShapelessRecipe(stick);
        recipe.addIngredient(2, Material.DIAMOND);

        return recipe;
    }

    //1 GLowstoneblock = 4 glowstone
    private ShapelessRecipe glowstone() {
        ItemStack glowstone_dust = new ItemStack(Material.GLOWSTONE_DUST);
        glowstone_dust.setAmount(4);

        ShapelessRecipe recipe = new ShapelessRecipe(glowstone_dust);
        recipe.addIngredient(1, Material.GLOWSTONE);

        return recipe;
    }

    //2 Slaps in 1 Block
    private ShapedRecipe slaps(int ka, Material mat_block, Material slap) {
        ItemStack block = new ItemStack(mat_block);

        ShapedRecipe recipe = new ShapedRecipe(block);
        switch (ka) {
            case 0:
                recipe.shape("w  ", "w  ", "   ");
                break;
            case 1:
                recipe.shape(" w ", " w ", "   ");
                break;
            case 2:
                recipe.shape("   ", "w  ", "w  ");
                break;
            case 3:
                recipe.shape("   ", " w ", " w ");
                break;
        }
        recipe.setIngredient('w', slap);

        return recipe;
    }

    //Material List für Blöcke
    private Map<String, Material[]> material_list() {
        Map<String, Material[]> map = new LinkedHashMap<>();


        Material[] cut_copper = {Material.CUT_COPPER_SLAB, Material.CUT_COPPER};
        map.put("cut_copper", cut_copper);

        Material[] exposed_cut_copper = {Material.EXPOSED_CUT_COPPER_SLAB, Material.EXPOSED_CUT_COPPER};
        map.put("exposed_cut_copper", exposed_cut_copper);

        Material[] weathered_cut_copper = {Material.WEATHERED_CUT_COPPER_SLAB, Material.WEATHERED_CUT_COPPER};
        map.put("weathered_cut_copper", weathered_cut_copper);

        Material[] oxidized_cut_copper = {Material.OXIDIZED_CUT_COPPER_SLAB, Material.OXIDIZED_CUT_COPPER};
        map.put("oxidized_cut_copper", oxidized_cut_copper);

        Material[] waxed_cut_copper = {Material.WAXED_CUT_COPPER_SLAB, Material.WAXED_CUT_COPPER};
        map.put("waxed_cut_copper", waxed_cut_copper);

        Material[] waxed_exposed_cut_copper = {Material.WAXED_EXPOSED_CUT_COPPER_SLAB, Material.WAXED_EXPOSED_CUT_COPPER};
        map.put("waxed_exposed_cut_copper", waxed_exposed_cut_copper);

        Material[] waxed_weathered_cut_copper = {Material.WAXED_WEATHERED_CUT_COPPER_SLAB, Material.WAXED_WEATHERED_CUT_COPPER};
        map.put("waxed_weathered_cut_copper", waxed_weathered_cut_copper);

        Material[] waxed_oxidized_cut_copper = {Material.WAXED_OXIDIZED_CUT_COPPER_SLAB, Material.WAXED_OXIDIZED_CUT_COPPER};
        map.put("waxed_oxidized_cut_copper", waxed_oxidized_cut_copper);

        Material[] oak = {Material.OAK_SLAB, Material.OAK_PLANKS};
        map.put("oak", oak);

        Material[] spruce = {Material.SPRUCE_SLAB, Material.SPRUCE_PLANKS};
        map.put("spruce", spruce);

        Material[] birch = {Material.BIRCH_SLAB, Material.BIRCH_PLANKS};
        map.put("birch", birch);

        Material[] jungle = {Material.JUNGLE_SLAB, Material.JUNGLE_PLANKS};
        map.put("jungle", jungle);

        Material[] acacia = {Material.ACACIA_SLAB, Material.ACACIA_PLANKS};
        map.put("acacia", acacia);

        Material[] dark_oak = {Material.DARK_OAK_SLAB, Material.DARK_OAK_PLANKS};
        map.put("dark_oak", dark_oak);

        Material[] mangrove = {Material.MANGROVE_SLAB, Material.MANGROVE_PLANKS};
        map.put("mangrove", mangrove);

        Material[] crimson = {Material.CRIMSON_SLAB, Material.CRIMSON_PLANKS};
        map.put("crimson", crimson);

        Material[] warped = {Material.WARPED_SLAB, Material.WARPED_PLANKS};
        map.put("warped", warped);

        Material[] stone = {Material.STONE_SLAB, Material.STONE};
        map.put("stone", stone);

        Material[] smooth_stone = {Material.SMOOTH_STONE_SLAB, Material.SMOOTH_STONE};
        map.put("smooth_stone", smooth_stone);

        Material[] sandstone = {Material.SANDSTONE_SLAB, Material.SANDSTONE};
        map.put("sandstone", sandstone);

        Material[] cut_sandstone = {Material.CUT_SANDSTONE_SLAB, Material.CUT_SANDSTONE};
        map.put("cut_sandstone", cut_sandstone);

        Material[] cobblestone = {Material.COBBLESTONE_SLAB, Material.COBBLESTONE};
        map.put("cobblestone", cobblestone);

        Material[] brick = {Material.BRICK_SLAB, Material.BRICK};
        map.put("brick", brick);

        Material[] stone_brick = {Material.STONE_BRICK_SLAB, Material.STONE_BRICKS};
        map.put("stone_brick", stone_brick);

        Material[] mud_brick = {Material.MUD_BRICK_SLAB, Material.MUD_BRICKS};
        map.put("mud_brick", mud_brick);

        Material[] nether_brick = {Material.NETHER_BRICK_SLAB, Material.NETHER_BRICKS};
        map.put("nether_brick", nether_brick);

        Material[] quartz = {Material.QUARTZ_SLAB, Material.QUARTZ_BLOCK};
        map.put("quartz", quartz);

        Material[] red_sandstone = {Material.RED_SANDSTONE_SLAB, Material.RED_SANDSTONE};
        map.put("red_sandstone", red_sandstone);

        Material[] cut_red_sandstone = {Material.CUT_RED_SANDSTONE_SLAB, Material.CUT_RED_SANDSTONE};
        map.put("cut_red_sandstone", cut_red_sandstone);

        Material[] purpur = {Material.PURPUR_SLAB, Material.PURPUR_BLOCK};
        map.put("purpur", purpur);

        Material[] prismarine = {Material.PRISMARINE_SLAB, Material.PRISMARINE};
        map.put("prismarine", prismarine);

        Material[] prismarine_brick = {Material.PRISMARINE_BRICK_SLAB, Material.PRISMARINE_BRICKS};
        map.put("prismarine_brick", prismarine_brick);

        Material[] dark_prismarine = {Material.DARK_PRISMARINE_SLAB, Material.DARK_PRISMARINE};
        map.put("dark_prismarine", dark_prismarine);

        Material[] polished_granite = {Material.POLISHED_GRANITE_SLAB, Material.POLISHED_GRANITE};
        map.put("polished_granite", polished_granite);

        Material[] smooth_red_sandstone = {Material.SMOOTH_RED_SANDSTONE_SLAB, Material.SMOOTH_RED_SANDSTONE};
        map.put("smooth_red_sandstone", smooth_red_sandstone);

        Material[] mossy_stone_brick = {Material.MOSSY_STONE_BRICK_SLAB, Material.MOSSY_STONE_BRICKS};
        map.put("mossy_stone_brick", mossy_stone_brick);

        Material[] polished_diorite = {Material.POLISHED_DIORITE_SLAB, Material.POLISHED_DIORITE};
        map.put("polished_diorite", polished_diorite);

        Material[] mossy_cobblestone = {Material.MOSSY_COBBLESTONE_SLAB, Material.MOSSY_COBBLESTONE};
        map.put("mossy_cobblestone", mossy_cobblestone);

        Material[] endstone_brick = {Material.END_STONE_BRICK_SLAB, Material.END_STONE_BRICKS};
        map.put("endstone_brick", endstone_brick);

        Material[] smooth_sandstone = {Material.SMOOTH_SANDSTONE_SLAB, Material.SMOOTH_SANDSTONE};
        map.put("smooth_sandstone", smooth_sandstone);

        Material[] smooth_quartz = {Material.SMOOTH_QUARTZ_SLAB, Material.SMOOTH_QUARTZ};
        map.put("smooth_quartz", smooth_quartz);

        Material[] granite = {Material.GRANITE_SLAB, Material.GRANITE};
        map.put("granite", granite);

        Material[] andesite = {Material.ANDESITE_SLAB, Material.ANDESITE};
        map.put("andesite", andesite);

        Material[] red_nether_brick = {Material.RED_NETHER_BRICK_STAIRS, Material.RED_NETHER_BRICKS};
        map.put("red_nether_brick", red_nether_brick);

        Material[] polished_andesite = {Material.POLISHED_ANDESITE_SLAB, Material.POLISHED_ANDESITE};
        map.put("polished_andesite", polished_andesite);

        Material[] diorite = {Material.DIORITE_SLAB, Material.DIORITE};
        map.put("diorite", diorite);

        Material[] cobbled_deepslate = {Material.COBBLED_DEEPSLATE_SLAB, Material.COBBLED_DEEPSLATE};
        map.put("cobbled_deepslate", cobbled_deepslate);

        Material[] polished_deepslate = {Material.POLISHED_DEEPSLATE_SLAB, Material.POLISHED_DEEPSLATE};
        map.put("polished_deepslate", polished_deepslate);

        Material[] deepslate_brick = {Material.DEEPSLATE_BRICK_SLAB, Material.DEEPSLATE_BRICKS};
        map.put("deepslate_brick", deepslate_brick);

        Material[] deepslate_tile = {Material.DEEPSLATE_TILE_SLAB, Material.DEEPSLATE_TILES};
        map.put("deepslate_tile", deepslate_tile);

        Material[] blakckstone = {Material.BLACKSTONE_SLAB, Material.BLACKSTONE};
        map.put("blakckstone", blakckstone);

        Material[] polished_blackstone = {Material.POLISHED_BLACKSTONE_SLAB, Material.POLISHED_BLACKSTONE};
        map.put("polished_blackstone", polished_blackstone);

        Material[] polished_blackstone_brick = {Material.POLISHED_BLACKSTONE_BRICK_SLAB, Material.POLISHED_BLACKSTONE_BRICKS};
        map.put("polished_blackstone_brick", polished_blackstone_brick);

        return map;
    }

    //Hopper
    private ShapedRecipe hopper() {
        ItemStack hopper = new ItemStack(Material.HOPPER);

        ShapedRecipe recipe = new ShapedRecipe(hopper);
        recipe.shape("ewe", "ewe", " e ");
        recipe.setIngredient('e', Material.IRON_INGOT);
        recipe.setIngredient('w', Material.OAK_LOG);

        return recipe;
    }

    private FurnaceRecipe leather() {
        ItemStack leather = new ItemStack(Material.LEATHER);

        FurnaceRecipe recipe = new FurnaceRecipe(leather, Material.ROTTEN_FLESH);
        recipe.setCookingTime(1200);
        recipe.setExperience(1);

        return recipe;
    }
}
