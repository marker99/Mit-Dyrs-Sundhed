package com.github.marker99.ui.signalement.add;

import com.github.marker99.persistence.pet.Pet;

public interface AddSignalementViewModel {
    //Fixme: hvorfor Final?
    void insert(final Pet pet);
}
