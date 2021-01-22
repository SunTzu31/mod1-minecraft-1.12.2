package alex.mod1.world.generation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import alex.mod1.init.BlockInit;
import alex.mod1.world.biomes.BiomeCity;
import alex.mod1.world.generation.generators.WorldGenStructure;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDesert;
import net.minecraft.world.biome.BiomeOcean;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;


public class WorldGenCustomStructures implements IWorldGenerator
{
    public WorldGenStructure CASTLE_1 = new WorldGenStructure("castle_1");
    public WorldGenStructure CASTLE_2 = new WorldGenStructure("castle_2");
    
    
    public WorldGenStructure[][][] FRIGATE = {  
                                               {   
                                                   {
                                                       new WorldGenStructure("frigate_back_down"), new WorldGenStructure("frigate_back_middle"), new WorldGenStructure("frigate_back_top") 
                                                   },
                                                   {
                                                       new WorldGenStructure("frigate_right_down"), new WorldGenStructure("frigate_right_middle"), new WorldGenStructure("frigate_right_top")
                                                   }
                                               }, 
                                                   
                                               {   
                                                   {
                                                       null
                                                   },
                                                   {
                                                       new WorldGenStructure("frigate_front_down"), new WorldGenStructure("frigate_front_middle") 
                                                   },
                                                   
                                               },
                                             
                                                 
     
                                            };
    
    
    public int[][][] frigate_disposition =  //decalage entre chacque chunk par rapport au précédant sur l'axe concerné dans l'ordre : Z,X,Y
        
        {
                {
                    {
                        0,32,32,  -32     //Y,Y,Y,  X         La dernière valeur est toujours le décalage de l'axe X et de l'axe Z seulement si c'est le dernier tableau parmis les axes X        
                    },
                    {                                                                       //size of an array should be the same as structure +1 
                        0,32,32,  32     //Y,Y,Y,  Z 
                    }
            
            
                },
                {
                    {
                        0,    -25          //Y,   X
                    },
                    {
                        0,32,  0          //Y,Y,   Z
                    }
                   
                    
                    
                }
        };
    
    
    
    
    
    
    
    
    
    
    public WorldGenStructure[][][] CITY = {  
            {   
                {
                    new WorldGenStructure("city000") 
                },
                {
                    new WorldGenStructure("city100")
                },
                {
                    new WorldGenStructure("city200")
                },
                {
                    new WorldGenStructure("city300")
                }
            }, 
                
            {   
                {
                    new WorldGenStructure("city001")
                },
                {
                    new WorldGenStructure("city101")
                },
                {
                    new WorldGenStructure("city201")
                },
                {
                    new WorldGenStructure("city301")
                }
                
            },
            {
                
                {
                    new WorldGenStructure("city002")
                },
                {
                    new WorldGenStructure("city102")
                },
                {
                    new WorldGenStructure("city202")
                },
                {
                    new WorldGenStructure("city302")
                }
            },
            {
                
                {
                    new WorldGenStructure("city003")
                },
                {
                    new WorldGenStructure("city103")
                },
                {
                    new WorldGenStructure("city203")
                },
                {
                    new WorldGenStructure("city303")
                }
            }
          
              

         };
    
    public int[][][] city_disposition = {
    {   
        {
            0,-32
        },
        {
            0,-32
        },
        {
            0,-32
        },
        {
            0,-32
        }
    }, 
        
    {   
        {
            0,-32
        },
        {
            0,-32
        },
        {
            0,-32
        },
        {
            0,-32
        }
        
    },
    {
        
        {
            0,-32
        },
        {
            0,-32
        },
        {
            0,-32
        },
        {
            0,-32
        }
    },
    {
        
        {
            0,-32
        },
        {
            0,-32
        },
        {
            0,-32
        },
        {
            0,-32
        }
    }
  
      

 };
    
    
    
    
    
    
    
    
    
    
 
    
    
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        
        switch(world.provider.getDimension())
        {
            case -1:                                  // nether
                
                break;
            case 0:                                     // overworld
                //generateStructure(CASTLE_1, CASTLE_2, 32, world, random, chunkX, chunkZ,  75, Blocks.GRASS, BiomeCity.class); //more the chance is great, less the structure will appear
                generateMultipartStructure(FRIGATE, frigate_disposition,  world, random, chunkX, chunkZ, 8000, Blocks.WATER, BiomeOcean.class);
                generateMultipartStructure(CITY, city_disposition, world, random, chunkX, chunkZ, 100, Blocks.GRASS, BiomePlains.class);
                //generateStructureTest(FRIGATE[0][0][0], world, random, chunkX, chunkZ, 50, Blocks.DIRT, BiomePlains.class);
               
                break;
            case 1:                                                                             // ender
                break;

        }

    }
    
    //ma méthode pour faire des structures plus grandes  
    //structure est la liste avec les différents chunk à spawn lenghtX,Y et Z sont l'écartement sur chaque axe entre les chunks
    //XChunks YChunks et ZChunks sont le nombe respectifs de chunks de la structure sur chaque axe
    
    private void generateMultipartStructure(WorldGenStructure[][][] structure, int[][][] structureDisposition, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes) 
    {
        ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));
        int x = (chunkX * 16) + random.nextInt(15) + 8;
        int z = (chunkZ * 16) + random.nextInt(15) + 8;
        int y = calculateGenerationHeight(world, x, z, topBlock);
        BlockPos pos = new BlockPos(x, y, z);
        int X = x;
        int Z = z;
        int Y = y;
        
        int decalageZ = 0;
        
        Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
        
        if(world.getWorldType() != WorldType.FLAT)
        {
            if(classesList.contains(biome))
            {
                if(random.nextInt(chance) == 0)
                {
                   
                    
                    for(int i= 0; i < structure.length; i++) {   //répète autant de fois que le nombre de chunks sur l'axe Z ex : frégate 2
                        
                        System.out.println("il y a " + structure.length + " chunks sur l'axe Z");
                        
                        for(int j= 0; j< (structure[i].length) ; j++) {   //répète autant de fois que le nombre de chunks sur l'axe X : frégate z0 = 2, z1 = 1
                            
                            System.out.println("il y a " + structure[i].length + " chunks sur l'axe X de Z = " + i);
                            
                            
                            for(int k = 0; k< (structureDisposition[i][j].length)-1  ; k++) {     //répète autant de fois que le nombre de chunks sur l'axe Y : frégate Z0X0 = 3, Z0X1 = 3, Z1X1 = 2
                                System.out.println("il y a " + ((structureDisposition[i][j].length)-1) + " chunks sur l'axe Y de Z = " + i + " et X = " + j);
                                pos = new BlockPos(X, Y += structureDisposition[i][j][k] , Z);
                                
                                
                                if(structure[i][j][k] == null) 
                                {
                                    System.out.println("chunk vide en " + pos);
                                    
                                }
                                else 
                                {
                                    
                                    structure[i][j][k].generate(world, random, pos);
                                    System.out.println("chunk généré en " + pos);
                                }
                                
                                
                                
                  
                                
                            }
                            Y = y;
                            pos = new BlockPos(X += structureDisposition[i][j][structure[i][j].length], Y , Z );
                            decalageZ = structureDisposition[i][j][structure[i][j].length];
                            
                            
                        }
                        Z += decalageZ;   //
                        X = x;
                        pos = new BlockPos(X , Y , Z);
                        
                       
                        
                        
                    }
                    System.out.println("FINIIIIIIIIIIIIIIIIIIi");
                    
                }
            }
        }
    }
    private void generateStructureTest(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes)
    {
        ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));

        int x = (chunkX * 16) + random.nextInt(15) +8;
        int z = (chunkZ * 16) + random.nextInt(15) +8;
        int y = calculateGenerationHeight(world, x, z, topBlock);
        BlockPos pos = new BlockPos(x, y, z);

        Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();

        if(world.getWorldType() != WorldType.FLAT)
        {
            if(classesList.contains(biome))
            {
                if(random.nextInt(chance) == 0)
                {
                    generator.generate(world, random, pos);
                    System.out.println("bout de frégate spawn en  " + pos);
                    
                   
                }
            }
        }

    }
    
    
    // la méthode de la vidéo
    private void generateStructure(WorldGenerator generator, WorldGenerator generator2, int lenghtX, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes)
    {
        ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));

        int x = (chunkX * 16) + random.nextInt(15) +8;
        int z = (chunkZ * 16) + random.nextInt(15) +8;
        int y = calculateGenerationHeight(world, x, z, topBlock);
        BlockPos pos = new BlockPos(x, y, z);

        Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();

        if(world.getWorldType() != WorldType.FLAT)
        {
            if(classesList.contains(biome))
            {
                if(random.nextInt(chance) == 0)
                {
                    generator.generate(world, random, pos);
                    System.out.println("castle1 pop mon frère en " + pos);
                    pos = new BlockPos(x += lenghtX , y, z);
                    generator2.generate(world, random, pos);
                    System.out.println("castle2 pop mon frère en " + pos);
                   
                }
            }
        }

    }

    
    private static int calculateGenerationHeight(World world, int x, int z, Block topBlock)
    {
        int y = world.getHeight();
        boolean foundGround = false;

        while(!foundGround && y-- >= 0)
        {
            Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
            foundGround = block == topBlock;
        }

        return y;
    }
}
