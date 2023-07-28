package com.gire.examen3_gianfranco_remaycuna.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gire.examen3_gianfranco_remaycuna.model.Person
import com.gire.examen3_gianfranco_remaycuna.repository.StarWarsRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val repository = StarWarsRepository()

    private val _people = MutableLiveData<List<Person>>()
    val people: LiveData<List<Person>> = _people

    init {
        viewModelScope.launch {
            val peopleResponse = repository.getPeople()
            _people.value = peopleResponse?.results
        }
    }

    private val _lukeSkywalker = MutableLiveData<Person>()
    val lukeSkywalker: LiveData<Person> = _lukeSkywalker

    init {
        val lukeSkywalker = Person(
            name = "Luke Skywalker",
            height = "172",
            mass = "77",
            hair_color = "blond",
            skin_color = "fair",
            eye_color = "blue",
            birth_year = "19BBY",
            gender = "male",
            homeworld = "https://swapi.dev/api/planets/1/",
            films = listOf(
                "https://swapi.dev/api/films/1/",
                "https://swapi.dev/api/films/2/",
                "https://swapi.dev/api/films/3/",
                "https://swapi.dev/api/films/6/"
            ),
            species = listOf(),
            vehicles = listOf(
                "https://swapi.dev/api/vehicles/14/",
                "https://swapi.dev/api/vehicles/30/"
            ),
            starships = listOf(
                "https://swapi.dev/api/starships/12/",
                "https://swapi.dev/api/starships/22/"
            ),
            created = "2014-12-09T13:50:51.644000Z",
            edited = "2014-12-20T21:17:56.891000Z",
            url = "https://swapi.dev/api/people/1/"
        )
        _lukeSkywalker.value = lukeSkywalker
    }

}
