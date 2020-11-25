package com.rezkalla.core.domain.usecase

import com.rezkalla.core.domain.repository.CitiesRepository
import com.rezkalla.core.domain.utils.TestDataGenerator
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class FilterCitiesUseCaseTest {
    @Mock
    private lateinit var repository: CitiesRepository

    private lateinit var useCase: FilterCitiesUseCase

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `test get all cities return list of cities successfully`() {
        // when
        val cities = TestDataGenerator.getTestData()
        Mockito.`when`(repository.getCities())
            .thenReturn(cities)

        // action
        useCase = FilterCitiesUseCase(repository)
        val results = useCase()

        // verify
        assertEquals(cities, results)
        assertTrue(results.isNotEmpty())
        assertEquals(cities.size, results.size)
        assertEquals(results[0], cities[0])

    }


    @Test
    fun `test get all cities return empty list successfully`() {
        // when
        Mockito.`when`(repository.getCities())
            .thenReturn(emptyList())

        // action
        useCase = FilterCitiesUseCase(repository)
        val results = useCase()

        // verify
        assertTrue(results.isEmpty())
    }

    @Test
    fun `test filter cities with prefix 'A' should return all cities start with 'A' successfully`() {

        // when
        val cities = TestDataGenerator.getTestData()
        Mockito.`when`(repository.getCities())
            .thenReturn(cities)

        // action
        useCase = FilterCitiesUseCase(repository)
        val results = useCase("A")

        // verify
        assertTrue(results.isNotEmpty())
        assertEquals(results.size, 4)
        results.forEach {
            assertTrue(it.name.startsWith("A", false))
        }

    }

    @Test
    fun `test filter cities with prefix 'Al' should return all cities start with 'Al' successfully`() {

        // when
        val cities = TestDataGenerator.getTestData()
        Mockito.`when`(repository.getCities())
            .thenReturn(cities)

        // action
        useCase = FilterCitiesUseCase(repository)
        val results = useCase("Al")

        // verify
        assertTrue(results.isNotEmpty())
        assertEquals(results.size, 2)
        results.forEach {
            assertTrue(it.name.startsWith("Al", false))
        }

    }

    @Test
    fun `test filter cities with prefix 'Alb' should return all cities start with 'Alb' successfully`() {

        // when
        val cities = TestDataGenerator.getTestData()
        Mockito.`when`(repository.getCities())
            .thenReturn(cities)

        // action
        useCase = FilterCitiesUseCase(repository)
        val results = useCase("Alb")

        // verify
        assertTrue(results.isNotEmpty())
        assertEquals(results.size, 1)
        results.forEach {
            assertTrue(it.name.startsWith("Alb", false))
        }

    }


    @Test
    fun `test filter cities with prefix 'S' should return all cities start with 'S' successfully`() {

        // when
        val cities = TestDataGenerator.getTestData()
        Mockito.`when`(repository.getCities())
            .thenReturn(cities)

        // action
        useCase = FilterCitiesUseCase(repository)
        val results = useCase("S")

        // verify
        assertTrue(results.isNotEmpty())
        assertEquals(results.size, 1)
        results.forEach {
            assertTrue(it.name.startsWith("S", false))
        }

    }


    @Test
    fun `test filter cities with prefix 'SSS' should return empty list of cities in case of not found`() {

        // when
        val cities = TestDataGenerator.getTestData()
        Mockito.`when`(repository.getCities())
            .thenReturn(cities)

        // action
        useCase = FilterCitiesUseCase(repository)
        val results = useCase("SSS")

        // verify
        assertTrue(results.isEmpty())

    }


}