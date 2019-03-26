package com.draper.itoken.sso.filter;

import com.draper.itoken.sso.domain.Const;
import com.draper.itoken.sso.util.RsaJwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author draper_hxy
 */
@Slf4j
public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private RsaJwtTokenUtil rsaJwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader(Const.HEADER_STRING);

        if (authHeader != null) {
            String authToken = authHeader;

            if (authHeader.startsWith("Bearer ")) {
                authToken = authHeader.substring(authToken.indexOf(" ") + 1, authToken.length());
            }

            String username = rsaJwtTokenUtil.getSubject(authToken);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                // 在数据库中查找 user， userDetails 实际上是一个 User 对象
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                if (rsaJwtTokenUtil.validateToken(authToken, userDetails)) {

                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                            request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }

        filterChain.doFilter(request, response);
    }

}
