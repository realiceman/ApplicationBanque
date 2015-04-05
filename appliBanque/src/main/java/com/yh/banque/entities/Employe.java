package com.yh.banque.entities;

import java.io.Serializable;
import java.util.Collection;

public class Employe implements Serializable {
  private Long codeEmploye;
  private String nomEmploye;
  private Employe employeSup;
  private Collection<Groupe> groupes;
  
}
