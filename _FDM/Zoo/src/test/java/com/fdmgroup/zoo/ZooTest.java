package com.fdmgroup.zoo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ZooTest 
{
	Zoo plotTwistZoo;
	Enclosure sunfishAquarium;
	List<Enclosure> enclosureList;
	Animal alomoma;
	Animal stunfish;
	Animal bruce;
	
	
	@Before
	public void setUp() throws Exception 
	{
		plotTwistZoo = new Zoo();
		sunfishAquarium = new Enclosure();
		plotTwistZoo.addEnclosure(sunfishAquarium);
		enclosureList = plotTwistZoo.getEnclosureList();
		bruce = new Shark(0, null, sunfishAquarium);
		
	}

	@After
	public void tearDown() throws Exception 
	{
	}

	@Test
	public void test_DoesZooExist_WhenWeInstantiatedNewZoo() 
	{
		assertNotNull(plotTwistZoo);
	}
	
	@Test
	public void test_DoesEnclosureExist_WhenWeInstantiatedNewEnclosure() 
	{
		plotTwistZoo.addEnclosure(sunfishAquarium);
		assertNotNull(sunfishAquarium);
	}

	@Test
	public void test_DoesZooHaveOneEnclosure_WhenWeInstantiatedOneEnclosure() 
	{
		assertEquals(1, plotTwistZoo.EnclosureList.size());
	}
	
	@Test
	public void test_DoTwoSunfishExistinSunfishAquarium_WhenWeAddTwoSunfishTotheSunfishAquarium()
	{
		alomoma = new Sunfish(594, "Allie", sunfishAquarium);
		stunfish = new Sunfish(618, "Sam", sunfishAquarium);
		
		sunfishAquarium.addAnimal(alomoma);
		sunfishAquarium.addAnimal(stunfish);
		
		List<Animal> aquariumPals = sunfishAquarium.getAnimalList();
		
		assertTrue(aquariumPals.contains(alomoma) && aquariumPals.contains(stunfish));
	}
	
	@Test
	public void test_IInstanstiatedFishAnAnimal_WhenWeInstantiateShark()
	{
		assertEquals(Animal.class, bruce.getClass().getSuperclass());
	}

}
