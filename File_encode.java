package me.chuggy.file_encode;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;

public final class File_encode extends JavaPlugin {

    private final Map<Byte, Material> blockLookupTable = new HashMap<>();
    private final Map<Material, Byte> byteLookupTable = new HashMap<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Started");
        getCommand("generateblocks").setExecutor(this);
        getCommand("decodeblocks").setExecutor(this);
        createLookupTable();
        createByteLookupTable();
        //outputMaterialsToFile();
        //outputDefinitionsToFile();
    }

    private void createLookupTable() {
        // Define your mapping of byte values to block types
        blockLookupTable.put((byte) 0, Material.STONE);
        blockLookupTable.put((byte) 1, Material.GRANITE);
        blockLookupTable.put((byte) 2, Material.POLISHED_GRANITE);
        blockLookupTable.put((byte) 3, Material.DIORITE);
        blockLookupTable.put((byte) 4, Material.POLISHED_DIORITE);
        blockLookupTable.put((byte) 5, Material.ANDESITE);
        blockLookupTable.put((byte) 6, Material.POLISHED_ANDESITE);
        blockLookupTable.put((byte) 7, Material.DEEPSLATE);
        blockLookupTable.put((byte) 8, Material.COBBLED_DEEPSLATE);
        blockLookupTable.put((byte) 9, Material.POLISHED_DEEPSLATE);
        blockLookupTable.put((byte) 10, Material.CALCITE);
        blockLookupTable.put((byte) 11, Material.COBBLESTONE);
        blockLookupTable.put((byte) 12, Material.OAK_PLANKS);
        blockLookupTable.put((byte) 13, Material.SPRUCE_PLANKS);
        blockLookupTable.put((byte) 14, Material.BIRCH_PLANKS);
        blockLookupTable.put((byte) 15, Material.JUNGLE_PLANKS);
        blockLookupTable.put((byte) 16, Material.ACACIA_PLANKS);
        blockLookupTable.put((byte) 17, Material.CHERRY_PLANKS);
        blockLookupTable.put((byte) 18, Material.DARK_OAK_PLANKS);
        blockLookupTable.put((byte) 19, Material.MANGROVE_PLANKS);
        blockLookupTable.put((byte) 20, Material.BAMBOO_PLANKS);
        blockLookupTable.put((byte) 21, Material.CRIMSON_PLANKS);
        blockLookupTable.put((byte) 22, Material.WARPED_PLANKS);
        blockLookupTable.put((byte) 23, Material.BAMBOO_MOSAIC);
        blockLookupTable.put((byte) 24, Material.COAL_ORE);
        blockLookupTable.put((byte) 25, Material.DEEPSLATE_COAL_ORE);
        blockLookupTable.put((byte) 26, Material.IRON_ORE);
        blockLookupTable.put((byte) 27, Material.DEEPSLATE_IRON_ORE);
        blockLookupTable.put((byte) 28, Material.COPPER_ORE);
        blockLookupTable.put((byte) 29, Material.DEEPSLATE_COPPER_ORE);
        blockLookupTable.put((byte) 30, Material.GOLD_ORE);
        blockLookupTable.put((byte) 31, Material.DEEPSLATE_GOLD_ORE);
        blockLookupTable.put((byte) 32, Material.EMERALD_ORE);
        blockLookupTable.put((byte) 33, Material.DEEPSLATE_EMERALD_ORE);
        blockLookupTable.put((byte) 34, Material.LAPIS_ORE);
        blockLookupTable.put((byte) 35, Material.DEEPSLATE_LAPIS_ORE);
        blockLookupTable.put((byte) 36, Material.DIAMOND_ORE);
        blockLookupTable.put((byte) 37, Material.DEEPSLATE_DIAMOND_ORE);
        blockLookupTable.put((byte) 38, Material.NETHER_GOLD_ORE);
        blockLookupTable.put((byte) 39, Material.NETHER_QUARTZ_ORE);
        blockLookupTable.put((byte) 40, Material.ANCIENT_DEBRIS);
        blockLookupTable.put((byte) 41, Material.COAL_BLOCK);
        blockLookupTable.put((byte) 42, Material.RAW_IRON_BLOCK);
        blockLookupTable.put((byte) 43, Material.RAW_COPPER_BLOCK);
        blockLookupTable.put((byte) 44, Material.RAW_GOLD_BLOCK);
        blockLookupTable.put((byte) 45, Material.AMETHYST_BLOCK);
        blockLookupTable.put((byte) 46, Material.IRON_BLOCK);
        blockLookupTable.put((byte) 47, Material.BLAST_FURNACE);
        blockLookupTable.put((byte) 48, Material.GOLD_BLOCK);
        blockLookupTable.put((byte) 49, Material.DIAMOND_BLOCK);
        blockLookupTable.put((byte) 50, Material.NETHERITE_BLOCK);
        blockLookupTable.put((byte) 51, Material.WAXED_COPPER_BLOCK);
        blockLookupTable.put((byte) 52, Material.WAXED_EXPOSED_COPPER);
        blockLookupTable.put((byte) 53, Material.WAXED_WEATHERED_COPPER);
        blockLookupTable.put((byte) 54, Material.WAXED_OXIDIZED_COPPER);
        blockLookupTable.put((byte) 55, Material.WAXED_EXPOSED_CUT_COPPER_STAIRS);
        blockLookupTable.put((byte) 56, Material.WAXED_OXIDIZED_CUT_COPPER_SLAB);
        blockLookupTable.put((byte) 57, Material.OAK_LOG);
        blockLookupTable.put((byte) 58, Material.SPRUCE_LOG);
        blockLookupTable.put((byte) 59, Material.BIRCH_LOG);
        blockLookupTable.put((byte) 60, Material.JUNGLE_LOG);
        blockLookupTable.put((byte) 61, Material.ACACIA_LOG);
        blockLookupTable.put((byte) 62, Material.CHERRY_LOG);
        blockLookupTable.put((byte) 63, Material.DARK_OAK_LOG);
        blockLookupTable.put((byte) 64, Material.MANGROVE_LOG);
        blockLookupTable.put((byte) 65, Material.GLASS);
        blockLookupTable.put((byte) 66, Material.LAPIS_BLOCK);
        blockLookupTable.put((byte) 67, Material.SANDSTONE);
        blockLookupTable.put((byte) 68, Material.CHISELED_SANDSTONE);
        blockLookupTable.put((byte) 69, Material.CUT_SANDSTONE);
        blockLookupTable.put((byte) 70, Material.NETHER_WART_BLOCK);
        blockLookupTable.put((byte) 71, Material.WHITE_WOOL);
        blockLookupTable.put((byte) 72, Material.ORANGE_WOOL);
        blockLookupTable.put((byte) 73, Material.MAGENTA_WOOL);
        blockLookupTable.put((byte) 74, Material.LIGHT_BLUE_WOOL);
        blockLookupTable.put((byte) 75, Material.YELLOW_WOOL);
        blockLookupTable.put((byte) 76, Material.LIME_WOOL);
        blockLookupTable.put((byte) 77, Material.PINK_WOOL);
        blockLookupTable.put((byte) 78, Material.GRAY_WOOL);
        blockLookupTable.put((byte) 79, Material.LIGHT_GRAY_WOOL);
        blockLookupTable.put((byte) 80, Material.CYAN_WOOL);
        blockLookupTable.put((byte) 81, Material.PURPLE_WOOL);
        blockLookupTable.put((byte) 82, Material.BLUE_WOOL);
        blockLookupTable.put((byte) 83, Material.BROWN_WOOL);
        blockLookupTable.put((byte) 84, Material.GREEN_WOOL);
        blockLookupTable.put((byte) 85, Material.RED_WOOL);
        blockLookupTable.put((byte) 86, Material.BLACK_WOOL);
        blockLookupTable.put((byte) 87, Material.OAK_SLAB);
        blockLookupTable.put((byte) 88, Material.SPRUCE_SLAB);
        blockLookupTable.put((byte) 89, Material.BIRCH_SLAB);
        blockLookupTable.put((byte) 90, Material.JUNGLE_SLAB);
        blockLookupTable.put((byte) 91, Material.ACACIA_SLAB);
        blockLookupTable.put((byte) 92, Material.CHERRY_SLAB);
        blockLookupTable.put((byte) 93, Material.DARK_OAK_SLAB);
        blockLookupTable.put((byte) 94, Material.MANGROVE_SLAB);
        blockLookupTable.put((byte) 95, Material.BAMBOO_SLAB);
        blockLookupTable.put((byte) 96, Material.BAMBOO_MOSAIC_SLAB);
        blockLookupTable.put((byte) 97, Material.CRIMSON_SLAB);
        blockLookupTable.put((byte) 98, Material.WARPED_SLAB);
        blockLookupTable.put((byte) 99, Material.STONE_SLAB);
        blockLookupTable.put((byte) 100, Material.SMOOTH_STONE_SLAB);
        blockLookupTable.put((byte) 101, Material.SANDSTONE_SLAB);
        blockLookupTable.put((byte) 102, Material.CUT_SANDSTONE_SLAB);
        blockLookupTable.put((byte) 103, Material.PETRIFIED_OAK_SLAB);
        blockLookupTable.put((byte) 104, Material.COBBLESTONE_SLAB);
        blockLookupTable.put((byte) 105, Material.BRICK_SLAB);
        blockLookupTable.put((byte) 106, Material.STONE_BRICK_SLAB);
        blockLookupTable.put((byte) 107, Material.MUD_BRICK_SLAB);
        blockLookupTable.put((byte) 108, Material.NETHER_BRICK_SLAB);
        blockLookupTable.put((byte) 109, Material.QUARTZ_SLAB);
        blockLookupTable.put((byte) 110, Material.RED_SANDSTONE_SLAB);
        blockLookupTable.put((byte) 111, Material.CUT_RED_SANDSTONE_SLAB);
        blockLookupTable.put((byte) 112, Material.PRISMARINE_SLAB);
        blockLookupTable.put((byte) 113, Material.PRISMARINE_BRICK_SLAB);
        blockLookupTable.put((byte) 114, Material.DARK_PRISMARINE_SLAB);
        blockLookupTable.put((byte) 115, Material.SMOOTH_QUARTZ);
        blockLookupTable.put((byte) 116, Material.BRICKS);
        blockLookupTable.put((byte) 117, Material.BOOKSHELF);
        blockLookupTable.put((byte) 118, Material.CHISELED_BOOKSHELF);
        blockLookupTable.put((byte) 119, Material.MOSSY_COBBLESTONE);
        blockLookupTable.put((byte) 120, Material.OBSIDIAN);
        blockLookupTable.put((byte) 121, Material.BONE_BLOCK);
        blockLookupTable.put((byte) 122, Material.SPAWNER);
        blockLookupTable.put((byte) 123, Material.CHEST);
        blockLookupTable.put((byte) 124, Material.CRAFTING_TABLE);
        blockLookupTable.put((byte) 125, Material.FURNACE);
        blockLookupTable.put((byte) 126, Material.COBBLESTONE_STAIRS);
        blockLookupTable.put((byte) 127, Material.SNOW_BLOCK);
        blockLookupTable.put((byte) 128, Material.CLAY);
        blockLookupTable.put((byte) 129, Material.JUKEBOX);
        blockLookupTable.put((byte) 130, Material.OAK_FENCE);
        blockLookupTable.put((byte) 131, Material.SPRUCE_FENCE);
        blockLookupTable.put((byte) 132, Material.BIRCH_FENCE);
        blockLookupTable.put((byte) 133, Material.JUNGLE_FENCE);
        blockLookupTable.put((byte) 134, Material.ACACIA_FENCE);
        blockLookupTable.put((byte) 135, Material.CHERRY_FENCE);
        blockLookupTable.put((byte) 136, Material.DARK_OAK_FENCE);
        blockLookupTable.put((byte) 137, Material.MANGROVE_FENCE);
        blockLookupTable.put((byte) 138, Material.BAMBOO_FENCE);
        blockLookupTable.put((byte) 139, Material.CRIMSON_FENCE);
        blockLookupTable.put((byte) 140, Material.WARPED_FENCE);
        blockLookupTable.put((byte) 141, Material.PUMPKIN);
        blockLookupTable.put((byte) 142, Material.CARVED_PUMPKIN);
        blockLookupTable.put((byte) 143, Material.JACK_O_LANTERN);
        blockLookupTable.put((byte) 144, Material.NETHERRACK);
        blockLookupTable.put((byte) 145, Material.SOUL_SAND);
        blockLookupTable.put((byte) 146, Material.SOUL_SOIL);
        blockLookupTable.put((byte) 147, Material.BASALT);
        blockLookupTable.put((byte) 148, Material.POLISHED_BASALT);
        blockLookupTable.put((byte) 149, Material.SMOOTH_BASALT);
        blockLookupTable.put((byte) 150, Material.GLOWSTONE);
        blockLookupTable.put((byte) 151, Material.STONE_BRICKS);
        blockLookupTable.put((byte) 152, Material.MOSSY_STONE_BRICKS);
        blockLookupTable.put((byte) 153, Material.CRACKED_STONE_BRICKS);
        blockLookupTable.put((byte) 154, Material.CHISELED_STONE_BRICKS);
        blockLookupTable.put((byte) 155, Material.MUD_BRICKS);
        blockLookupTable.put((byte) 156, Material.DEEPSLATE_BRICKS);
        blockLookupTable.put((byte) 157, Material.CRACKED_DEEPSLATE_BRICKS);
        blockLookupTable.put((byte) 158, Material.DEEPSLATE_TILES);
        blockLookupTable.put((byte) 159, Material.CRACKED_DEEPSLATE_TILES);
        blockLookupTable.put((byte) 160, Material.CHISELED_DEEPSLATE);
        blockLookupTable.put((byte) 161, Material.REINFORCED_DEEPSLATE);
        blockLookupTable.put((byte) 162, Material.BROWN_MUSHROOM_BLOCK);
        blockLookupTable.put((byte) 163, Material.RED_MUSHROOM_BLOCK);
        blockLookupTable.put((byte) 164, Material.MUSHROOM_STEM);
        blockLookupTable.put((byte) 165, Material.IRON_BARS);
        blockLookupTable.put((byte) 166, Material.GLASS_PANE);
        blockLookupTable.put((byte) 167, Material.MELON);
        blockLookupTable.put((byte) 168, Material.BRICK_STAIRS);
        blockLookupTable.put((byte) 169, Material.STONE_BRICK_STAIRS);
        blockLookupTable.put((byte) 170, Material.MUD_BRICK_STAIRS);
        blockLookupTable.put((byte) 171, Material.NETHER_BRICKS);
        blockLookupTable.put((byte) 172, Material.CRACKED_NETHER_BRICKS);
        blockLookupTable.put((byte) 173, Material.CHISELED_NETHER_BRICKS);
        blockLookupTable.put((byte) 174, Material.NETHER_BRICK_FENCE);
        blockLookupTable.put((byte) 175, Material.NETHER_BRICK_STAIRS);
        blockLookupTable.put((byte) 176, Material.ENCHANTING_TABLE);
        blockLookupTable.put((byte) 177, Material.END_PORTAL_FRAME);
        blockLookupTable.put((byte) 178, Material.END_STONE);
        blockLookupTable.put((byte) 179, Material.END_STONE_BRICKS);
        blockLookupTable.put((byte) 180, Material.SANDSTONE_STAIRS);
        blockLookupTable.put((byte) 181, Material.ENDER_CHEST);
        blockLookupTable.put((byte) 182, Material.EMERALD_BLOCK);
        blockLookupTable.put((byte) 183, Material.OAK_STAIRS);
        blockLookupTable.put((byte) 184, Material.SPRUCE_STAIRS);
        blockLookupTable.put((byte) 185, Material.BIRCH_STAIRS);
        blockLookupTable.put((byte) 186, Material.JUNGLE_STAIRS);
        blockLookupTable.put((byte) 187, Material.ACACIA_STAIRS);
        blockLookupTable.put((byte) 188, Material.CHERRY_STAIRS);
        blockLookupTable.put((byte) 189, Material.DARK_OAK_STAIRS);
        blockLookupTable.put((byte) 190, Material.MANGROVE_STAIRS);
        blockLookupTable.put((byte) 191, Material.BAMBOO_STAIRS);
        blockLookupTable.put((byte) 192, Material.BAMBOO_MOSAIC_STAIRS);
        blockLookupTable.put((byte) 193, Material.CRIMSON_STAIRS);
        blockLookupTable.put((byte) 194, Material.WARPED_STAIRS);
        blockLookupTable.put((byte) 195, Material.COMMAND_BLOCK);
        blockLookupTable.put((byte) 196, Material.BEACON);
        blockLookupTable.put((byte) 197, Material.COBBLESTONE_WALL);
        blockLookupTable.put((byte) 198, Material.MOSSY_COBBLESTONE_WALL);
        blockLookupTable.put((byte) 199, Material.BRICK_WALL);
        blockLookupTable.put((byte) 200, Material.PRISMARINE_WALL);
        blockLookupTable.put((byte) 201, Material.RED_SANDSTONE_WALL);
        blockLookupTable.put((byte) 202, Material.MOSSY_STONE_BRICK_WALL);
        blockLookupTable.put((byte) 203, Material.GRANITE_WALL);
        blockLookupTable.put((byte) 204, Material.STONE_BRICK_WALL);
        blockLookupTable.put((byte) 205, Material.MUD_BRICK_WALL);
        blockLookupTable.put((byte) 206, Material.NETHER_BRICK_WALL);
        blockLookupTable.put((byte) 207, Material.ANDESITE_WALL);
        blockLookupTable.put((byte) 208, Material.RED_NETHER_BRICK_WALL);
        blockLookupTable.put((byte) 209, Material.SANDSTONE_WALL);
        blockLookupTable.put((byte) 210, Material.END_STONE_BRICK_WALL);
        blockLookupTable.put((byte) 211, Material.DIORITE_WALL);
        blockLookupTable.put((byte) 212, Material.BLACKSTONE_WALL);
        blockLookupTable.put((byte) 213, Material.POLISHED_BLACKSTONE_WALL);
        blockLookupTable.put((byte) 214, Material.POLISHED_BLACKSTONE_BRICK_WALL);
        blockLookupTable.put((byte) 215, Material.COBBLED_DEEPSLATE_WALL);
        blockLookupTable.put((byte) 216, Material.POLISHED_DEEPSLATE_WALL);
        blockLookupTable.put((byte) 217, Material.DEEPSLATE_BRICK_WALL);
        blockLookupTable.put((byte) 218, Material.DEEPSLATE_TILE_WALL);
        blockLookupTable.put((byte) 219, Material.CHISELED_QUARTZ_BLOCK);
        blockLookupTable.put((byte) 220, Material.QUARTZ_BLOCK);
        blockLookupTable.put((byte) 221, Material.QUARTZ_BRICKS);
        blockLookupTable.put((byte) 222, Material.QUARTZ_PILLAR);
        blockLookupTable.put((byte) 223, Material.QUARTZ_STAIRS);
        blockLookupTable.put((byte) 224, Material.WHITE_TERRACOTTA);
        blockLookupTable.put((byte) 225, Material.ORANGE_TERRACOTTA);
        blockLookupTable.put((byte) 226, Material.MAGENTA_TERRACOTTA);
        blockLookupTable.put((byte) 227, Material.LIGHT_BLUE_TERRACOTTA);
        blockLookupTable.put((byte) 228, Material.YELLOW_TERRACOTTA);
        blockLookupTable.put((byte) 229, Material.LIME_TERRACOTTA);
        blockLookupTable.put((byte) 230, Material.PINK_TERRACOTTA);
        blockLookupTable.put((byte) 231, Material.GRAY_TERRACOTTA);
        blockLookupTable.put((byte) 232, Material.LIGHT_GRAY_TERRACOTTA);
        blockLookupTable.put((byte) 233, Material.CYAN_TERRACOTTA);
        blockLookupTable.put((byte) 234, Material.PURPLE_TERRACOTTA);
        blockLookupTable.put((byte) 235, Material.BLUE_TERRACOTTA);
        blockLookupTable.put((byte) 236, Material.BROWN_TERRACOTTA);
        blockLookupTable.put((byte) 237, Material.GREEN_TERRACOTTA);
        blockLookupTable.put((byte) 238, Material.RED_TERRACOTTA);
        blockLookupTable.put((byte) 239, Material.BLACK_TERRACOTTA);
        blockLookupTable.put((byte) 240, Material.PACKED_ICE);
        blockLookupTable.put((byte) 241, Material.WHITE_STAINED_GLASS);
        blockLookupTable.put((byte) 242, Material.ORANGE_STAINED_GLASS);
        blockLookupTable.put((byte) 243, Material.MAGENTA_STAINED_GLASS);
        blockLookupTable.put((byte) 244, Material.LIGHT_BLUE_STAINED_GLASS);
        blockLookupTable.put((byte) 245, Material.YELLOW_STAINED_GLASS);
        blockLookupTable.put((byte) 246, Material.LIME_STAINED_GLASS);
        blockLookupTable.put((byte) 247, Material.PINK_STAINED_GLASS);
        blockLookupTable.put((byte) 248, Material.GRAY_STAINED_GLASS);
        blockLookupTable.put((byte) 249, Material.LIGHT_GRAY_STAINED_GLASS);
        blockLookupTable.put((byte) 250, Material.CYAN_STAINED_GLASS);
        blockLookupTable.put((byte) 251, Material.PURPLE_STAINED_GLASS);
        blockLookupTable.put((byte) 252, Material.BLUE_STAINED_GLASS);
        blockLookupTable.put((byte) 253, Material.BROWN_STAINED_GLASS);
        blockLookupTable.put((byte) 254, Material.GREEN_STAINED_GLASS);
        blockLookupTable.put((byte) 255, Material.RED_STAINED_GLASS);
    }

    private void createByteLookupTable(){
        for(byte key : blockLookupTable.keySet()){
            //Create opposite lookup table, use <value, key> pair instead of <key, value> pair>
            byteLookupTable.put(blockLookupTable.get(key), key);
        }
    }

    private void outputMaterialsToFile() {
        File outputFile = new File(getDataFolder(), "Materials.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (Material material : Material.values()) {
                writer.write(material.name());
                writer.newLine();
            }

            getLogger().info("Materials have been written to Materials.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void outputDefinitionsToFile() {
        File outputFile = new File(getDataFolder(), "Definitions.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (int i = 0; i <= 255; i++) {
                writer.write("blockLookupTable.put((byte) "+ i + ", Material.);");
                writer.newLine();
            }

            getLogger().info("Definitions have been written to Definitions.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("generateblocks")) {
            // Specify the path to your binary file
            String filePath = "C:\\Users\\brend\\Desktop\\server\\daniel.mp4";

            // Load the binary data from the file
            byte[] binaryData = loadBinaryData(filePath);

            // Get the Bukkit world
            World world = Bukkit.getWorld("world");

            // Specify the starting location
            int startX = -1;
            int startY = 319;
            int startZ = -1;

            // Convert binary data to blocks
            convertBinaryToBlocks(world, startX, startY, startZ, binaryData);

            sender.sendMessage("Blocks generated successfully!");
            return true;
        }

        if (label.equalsIgnoreCase("decodeblocks")) {
            World world = Bukkit.getWorld("world");

            // Specify the starting location
            int startX = -1;
            int startY = 319;
            int startZ = -1;
            convertBlocksToFile(world, startX, startY, startZ);
            sender.sendMessage("Blocks decoded successfully!");
            return true;
        }

        return false;
    }




    private byte[] loadBinaryData(String filePath) {
        //Loads all data into memory at once, can do in chunks but I'm not gonna run out of memory with the files I'm using
        try (FileInputStream fileInputStream = new FileInputStream(new File(filePath))) {
            byte[] data = new byte[fileInputStream.available()];
            fileInputStream.read(data);
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void convertBinaryToBlocks(World world, int startX, int startY, int startZ, byte[] binaryData) {
        //for (byte b : binaryData) {

            //Material MaterialToUse = blockLookupTable.get(b);
            //Block block = world.getBlockAt(startX, startY, startZ);
            //block.setType(MaterialToUse);
            //startX++;

        //}

        int index = 0;
        Material MaterialToUse;
        Block block;
        while(true){
            for(int yOffset = 0; yOffset < 384; yOffset++){
                for(int zOffset = 0; zOffset < 16; zOffset++){
                    for(int xOffset = 0; xOffset < 16; xOffset++){
                        if(index == binaryData.length){
                            block = world.getBlockAt(startX - xOffset, startY - yOffset, startZ - zOffset);
                            block.setType(Material.BEDROCK);
                            return;
                        }
                        MaterialToUse = blockLookupTable.get(binaryData[index]);
                        block = world.getBlockAt(startX - xOffset, startY - yOffset, startZ - zOffset);
                        block.setType(MaterialToUse);
                        index++;
                    }
                }
            }
            startX += 16;
        }
    }

    private void convertBlocksToFile(World world, int startX, int startY, int startZ) {
        Block block;
        List<Byte> byteList = new ArrayList<>();
        while(true){
            for(int yOffset = 0; yOffset < 384; yOffset++){
                for(int zOffset = 0; zOffset < 16; zOffset++){
                    for(int xOffset = 0; xOffset < 16; xOffset++){
                        block = world.getBlockAt(startX - xOffset, startY - yOffset, startZ - zOffset);
                        if(block.getType() == Material.BEDROCK){
                            appendBytesToFile(byteList);
                            return;
                        }
                        System.out.println("Current block: " + block.getType() + "\t corresponding to byte: " + byteLookupTable.get(block.getType()) + "\t at ( " + (startX - xOffset) + " , " + (startY - yOffset) + " , " + (startZ - zOffset) + ")");
                        byte decodedBlock = byteLookupTable.get(block.getType());
                        byteList.add(decodedBlock);
                    }
                }
            }
            startX += 16;
        }

    }
    private void appendBytesToFile(List<Byte> byteList) {
        byte[] byteArray = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            byteArray[i] = byteList.get(i);
        }

        try (FileOutputStream fos = new FileOutputStream("decoded")) {
            fos.write(byteArray);
            System.out.println("Bytes written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Daniel larson");
    }
}
