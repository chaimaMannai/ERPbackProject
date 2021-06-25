package ERP.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
  ROLE_SALE_RES, ROLE_STOCK_RES;

  public String getAuthority() {
    return name();
  }

}
