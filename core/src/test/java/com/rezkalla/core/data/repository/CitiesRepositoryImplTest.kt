package com.rezkalla.core.data.repository

import com.rezkalla.core.data.source.CitiesLocalDataSource
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
class CitiesRepositoryImplTest {

    @Mock
    private lateinit var localDataSource: CitiesLocalDataSource

    private lateinit var repository: CitiesRepositoryImpl

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        repository = CitiesRepositoryImpl(localDataSource)
    }

    @Test
    fun `test get cities from repository return list of cities successfully`() {
        //when
        // when
        val cities = TestDataGenerator.getTestData()
        Mockito.`when`(localDataSource.getCities())
            .thenReturn(cities)

        // action
        val results = repository.getCities()

        //verify
        assertTrue(results.isNotEmpty())
        assertEquals(cities, results)
        assertEquals(cities.size,results.size)
        assertEquals(cities[0],results[0])
    }

    @Test
    fun `test get cities from repository return empty list successfully`() {
        //when
        // when
        Mockito.`when`(localDataSource.getCities())
            .thenReturn(emptyList())

        // action
        val results = repository.getCities()

        //verify
        assertTrue(results.isEmpty())
    }
}